package org.example;

import org.example.libraryItems.Book;
import org.example.libraryItems.LibraryItem;
import org.example.libraryItems.Move;

import java.util.ArrayList;
import java.util.List;

public class LibraryInterface {
    private final List<LibraryItem> database = new ArrayList<>();

    public void initLibrary( ) {
        database.add(new Book("Wilk Stepowy", "Hasse", 258));
        database.add(new Move("Wilk z Wall Street", "Martin Scorsese", 143));
        database.add(new Book("Pszczółka Maja", "Autor", 123));
        database.add(new Move("Openheimer", "Johny Deep", 183));
    }

    public void displayLibraryItems( ) {
        for (LibraryItem item : database) {
            System.out.println(item);
        }
    }

}
