package org.example;

import org.example.model.DataItem;
import org.example.model.SharedBuffer;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public final static int SIZE_BUFFER = 10;
    public final static int SIZE_EXECUTORS = 10;
    public final static int COUNT_CONSUMMERS = 5;
    public final static int COUNT_PRODUCERS = 1;

    public static void main(String[] args) {
        SharedBuffer shop = new SharedBuffer(SIZE_BUFFER);
        Runnable consumer = () -> consumerImplementation(shop);
        Runnable producer = () -> producerImplementation(shop);

        try (ExecutorService executorService = Executors.newFixedThreadPool(SIZE_EXECUTORS)) {
            for (int i = 0; i < COUNT_CONSUMMERS; i++) {
                executorService.execute(consumer);
            }
            for (int i = 0; i < COUNT_PRODUCERS; i++) {
                executorService.execute(producer);
            }
        }
    }

    private static void producerImplementation(SharedBuffer shop) {
        Random rand = new Random();
        while (true) {
            System.out.print(Thread.currentThread().getName() + "  ");
            shop.produce(new DataItem(LocalDateTime.now()));
            try {
                Thread.sleep(rand.nextInt(0, 1_000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private static void consumerImplementation(SharedBuffer shop) {
        while (true) {
            System.out.print(Thread.currentThread().getName() + "  ");
            shop.consume();
        }
    }
}