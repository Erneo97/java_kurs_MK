package org.example.model;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SharedBuffer {
    private int maxSize;
    private Queue<DataItem> sharedQueue = new ConcurrentLinkedQueue<>();

    public SharedBuffer(int maxSizeBuffer) {
        this.maxSize = maxSizeBuffer;
    }

    public void produce(DataItem dataItem) {
        if (sharedQueue.size() >= maxSize) {
            return;
        }
        System.out.printf("%d) Wyprodukowano %s\n", sharedQueue.size() + 1, dataItem.toString());
        sharedQueue.add(dataItem);
    }

    public void consume() {
        if (sharedQueue.isEmpty()) {
            return;
        }

        System.out.println("Skonsumowano " + sharedQueue.poll());
    }

}
