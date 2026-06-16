package org.example.libraryItems;

public class Book extends LibraryItem{
    private static int bookCounter = 0;

    public Book(String title, String autor, int lenght) {
        super(title, autor, lenght);
        bookCounter++;

    }

    public static int getBookCounter() {
        return bookCounter;
    }
}
