package org.example.exeptions;

public class ItemNotExist extends RuntimeException {
    public ItemNotExist(String message) {
        super(message);
    }
}
