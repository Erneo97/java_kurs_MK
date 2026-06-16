package org.example.exeptions;

public class ItemNotBorrowed extends RuntimeException {
    public ItemNotBorrowed(String message) {
        super(message);
    }
}
