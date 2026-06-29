package org.example;

import org.example.model.DataItem;
import org.example.model.PrintMessageThread;
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
        ExecutorService executorService = Executors.newFixedThreadPool(SIZE_EXECUTORS);
        SharedBuffer shop = new SharedBuffer(SIZE_BUFFER);

        Runnable consumer = () -> {
            while (true) {
                System.out.print(Thread.currentThread().getName() + "  ");
                shop.consume();
            }
        };
        Runnable producer = () -> {
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
        };

        for (int i = 0; i < COUNT_CONSUMMERS; i++) {
            executorService.execute(consumer);
        }
        for (int i = 0; i < COUNT_PRODUCERS; i++) {
            executorService.execute(producer);
        }
    }

    private static void basicThreadTest() {
        long timeToTerminateThreads = 3000;
        Thread threadPing = new Thread(new PrintMessageThread("Ping"));
        Thread threadPong = new Thread(new PrintMessageThread(" Pong\n"));
        try {
            threadPing.start();
            Thread.sleep(500);
            threadPong.start();

            threadPing.join(timeToTerminateThreads);
            threadPong.join(timeToTerminateThreads);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}