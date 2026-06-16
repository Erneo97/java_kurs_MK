package org.example.exeptions;

public class ItemNotBorrowed extends Exception {
    public ItemNotBorrowed(String message) {
        super(message);
    }
}
