package org.example.model;

public class PrintMessageThread implements Runnable {
    private final String message;

    public PrintMessageThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        try {
            int duration = 10;
            for (int i = 0; i < duration; i++) {
                System.out.print(message);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println(e);
            throw new RuntimeException(e);
        }
    }
}
