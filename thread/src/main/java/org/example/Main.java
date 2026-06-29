package org.example;

import org.example.model.DataItem;
import org.example.model.PrintMessageThread;
import org.example.model.SharedBuffer;

import java.time.LocalDateTime;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SharedBuffer shop = new SharedBuffer(5);
        Runnable consumer = () -> {
            while(true) {
                shop.consume();
            }
            };

        Runnable producer = () -> {
            Random rand = new Random();
            while(true) {
                shop.produce(new DataItem(LocalDateTime.now()));
                try {
                    Thread.sleep(rand.nextInt(0, 10_000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread consumeThread = new Thread(consumer);
        Thread producerThread = new Thread(producer);

        producerThread.start();
        consumeThread.start();

        try {
            producerThread.join();
            consumeThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void basicThreadTest() {
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
        };
    }
}