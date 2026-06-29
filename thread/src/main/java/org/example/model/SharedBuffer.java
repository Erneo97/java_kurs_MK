package org.example.model;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedBuffer {
    private int maxSize;
    private Queue<DataItem> sharedQueue = new ConcurrentLinkedQueue<>();

    private ReentrantLock lock = new ReentrantLock();
    Condition isEmptyCondition = lock.newCondition();
    Condition isFullCondition = lock.newCondition();

    public SharedBuffer(int maxSizeBuffer) {
        this.maxSize = maxSizeBuffer;
    }

    public void produce(DataItem dataItem) {
        criticalSection(() -> {
            while (sharedQueue.size() >= maxSize) {
                isFullCondition.await();
            }
            System.out.printf("%d) Wyprodukowano %s\n", sharedQueue.size() + 1, dataItem.toString());
            sharedQueue.add(dataItem);

            if (sharedQueue.size() >= maxSize) {
                isEmptyCondition.signalAll();
            }
        });
    }

    public void consume() {
        criticalSection(() -> {
            while (sharedQueue.isEmpty()) {
                isEmptyCondition.await();
            }
            System.out.printf("%d) Skonsumowano %s\n", sharedQueue.size(), sharedQueue.poll());

            if (sharedQueue.isEmpty()) {
                isFullCondition.signalAll();
            }
        });
    }

    private void criticalSection(InteruptibleAction section) {
        try {
            lock.lock();
            section.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
