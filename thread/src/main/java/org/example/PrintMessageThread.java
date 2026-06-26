package org.example;

public class PrintMessageThread implements Runnable {
    private final String message;

    public PrintMessageThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(message);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println(e);
            throw new RuntimeException(e);
        }


    }
}
