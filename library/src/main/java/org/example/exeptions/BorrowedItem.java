package org.example.exeptions;

public class BorrowedItem extends RuntimeException {
    public BorrowedItem(String message) {
        super(message);
    }
}
