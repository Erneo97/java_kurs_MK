package org.example.model;

public abstract class LibraryItem {
    protected final String title;
    protected final String autor;
    protected final int length;

    public LibraryItem(String title, String autor, int length) {
        this.title = title;
        this.autor = autor;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }
}
