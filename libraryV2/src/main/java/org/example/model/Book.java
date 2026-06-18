package org.example.model;

public class Book extends LibraryItem {
    private static int bookCounter = 0;

    public Book(String title, String autor, int pagesCount) {
        super(title, autor, pagesCount);
        bookCounter++;
    }

    public static int getBookCounter() {
        return bookCounter;
    }

    @Override
    public String toString() {
        return "Książka{" +
                "tytuł='" + title + '\'' +
                ", autor='" + autor + '\'' +
                ", l. stron=" + length +
                '}';
    }
}
