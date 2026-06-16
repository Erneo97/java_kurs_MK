package org.example.exeptions;

public class BorrowedItem extends Exception {
    public BorrowedItem(String message) {
        super(message);
    }
}
