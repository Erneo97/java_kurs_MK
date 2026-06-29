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

        sharedQueue.add(dataItem);
    }

    public DataItem consume() {
        return sharedQueue.poll();
    }

}
