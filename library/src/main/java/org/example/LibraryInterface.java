package org.example;

import org.example.exeptions.BorrowedItemExeption;
import org.example.exeptions.ItemNotBorrowedExeption;
import org.example.exeptions.ItemNotExist;
import org.example.model.Book;
import org.example.enums.BorrowItemStatus;
import org.example.model.LibraryItem;
import org.example.model.Move;

import java.util.HashMap;

public class LibraryInterface {
    private static final HashMap<LibraryItem, BorrowItemStatus> database = new HashMap<>();
    private static boolean initialized = false;

    public LibraryInterface() {
        initLibrary();
    }

    private void initLibrary() {
        if (initialized) {
            return;
        }
        database.put(new Book("Wilk Stepowy", "Hasse", 258), BorrowItemStatus.AVALIABLE);
        database.put(new Book("Pszczółka Maja", "Autor", 123), BorrowItemStatus.BORROWABLE);
        database.put(new Book("Noname", "NoName", 222), BorrowItemStatus.AVALIABLE);
        database.put(new Move("Wilk z Wall Street", "Martin Scorsese", 143), BorrowItemStatus.AVALIABLE);
        database.put(new Move("Openheimer", "Johny Deep", 183), BorrowItemStatus.AVALIABLE);
        initialized = true;
    }

    public void displayLibraryItems() {
        System.out.println("\tLista elementów dostępnych");
        displayItemsByStatus(BorrowItemStatus.AVALIABLE);

        System.out.println("\tLista elementów wypożyczonych");
        displayItemsByStatus(BorrowItemStatus.BORROWABLE);
    }

    private void displayItemsByStatus(BorrowItemStatus status) {
        for (LibraryItem item : database.keySet()) {
            if (database.get(item) == status) {
                System.out.println(item);
            }
        }
    }

    public void displayCountBookAndMovie() {
        System.out.printf("Liczba książek: %d\nLiczba filmów: %d\n", Book.getBookCounter(), Move.getMoveCounter());
    }

    public LibraryItem borrowItemByTitle(String title) throws BorrowedItemExeption {
        LibraryItem findItem = findItemByTitle(title);
        if (findItem == null) {
            throw new ItemNotExist(String.format("Tytuł: '%s' nie jest dostępny", title));
        }
        if (database.get(findItem).equals(BorrowItemStatus.AVALIABLE)) {
            database.put(findItem, BorrowItemStatus.BORROWABLE);
            return findItem;
        }
        throw new BorrowedItemExeption(String.format("Tytuł: '%s' - jest wypożyczony", title));
    }

    public LibraryItem findItemByTitle(String title) {
        for (LibraryItem item : database.keySet()) {
            if (item.getTitle().equals(title)) {
                return item;
            }
        }
        return null;
    }

    public void returnItemByTitle(String title) throws ItemNotBorrowedExeption {
        LibraryItem findItem = findItemByTitle(title);
        if (findItem == null) {
            throw new ItemNotExist(String.format("Tytuł: '%s' nie jest częścią biblioteki", title));
        }
        if (database.get(findItem).equals(BorrowItemStatus.BORROWABLE)) {
            database.put(findItem, BorrowItemStatus.AVALIABLE);
            return;
        }
        throw new ItemNotBorrowedExeption(String.format("Tytuł: '%s' - nie był wypożyczony", title));
    }
}
