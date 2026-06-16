package org.example.libraryItems;

public abstract class LibraryItem {
    protected String title;
    protected String autor;
    protected int lenght;

    public  LibraryItem(String title, String autor, int lenght) {
        this.title = title;
        this.autor = autor;
        this.lenght = lenght;
    }

    public String getTitle() {
        return title;
    }

    public String getAutor() {
        return autor;
    }

    public int getLenght() {
        return lenght;
    }
}
