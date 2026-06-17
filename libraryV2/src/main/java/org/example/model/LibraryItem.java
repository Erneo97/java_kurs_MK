package org.example.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LibraryItem that = (LibraryItem) o;
        return length == that.length && Objects.equals(title, that.title) && Objects.equals(autor, that.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, autor, length);
    }
}
