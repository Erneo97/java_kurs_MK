package org.example.exeptions;

public class BorrowedItemExeption extends Exception {
    public BorrowedItemExeption(String message) {
        super(message);
    }
}
