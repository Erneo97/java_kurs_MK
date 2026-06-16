package org.example;

import org.example.libraryItems.Book;
import org.example.libraryItems.LibraryItem;
import org.example.libraryItems.Move;

import java.util.HashMap;

public class LibraryInterface {
    private final HashMap<LibraryItem, Boolean> database = new HashMap<>();

    public void initLibrary() {
        database.put(new Book("Wilk Stepowy", "Hasse", 258), false);
        database.put(new Move("Wilk z Wall Street", "Martin Scorsese", 143), false);
        database.put(new Book("Pszczółka Maja", "Autor", 123), true);
        database.put(new Book("Noname", "NoName", 222), false);
        database.put(new Move("Openheimer", "Johny Deep", 183), false);
    }

    public void displayLibraryItems() {
        System.out.println("\tLista elementów dostępnych");
        displayAvailableItems();

        System.out.println("\tLista elementów wypożyczonych");
        displayBorrowedItems();
    }

    private void displayAvailableItems() {
        for (LibraryItem item : database.keySet()) {
            if(!database.get(item)) {
                System.out.println(item);
            }
        }
    }

    private void displayBorrowedItems() {
        for (LibraryItem item : database.keySet()) {
            if(database.get(item)) {
                System.out.println(item);
            }
        }
    }

    public void displayCountBookAndMovie( ) {
        System.out.printf("Liczba książek: %d\nLiczba filmów: %d\n", Book.getBookCounter(), Move.getMoveCounter());
    }

}
