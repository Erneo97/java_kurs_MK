package org.example;

import org.example.model.PrintMessageThread;

public class Main {
    public static void main(String[] args) {
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