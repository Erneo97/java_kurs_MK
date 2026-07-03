package org.example.model;

@FunctionalInterface
public interface InteruptibleAction {
    void run() throws InterruptedException;
}
