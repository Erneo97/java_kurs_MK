package org.example.service;

import org.example.exeptions.BorrowedItemExeption;
import org.example.exeptions.ItemNotBorrowedExeption;
import org.example.exeptions.ItemNotExist;
import org.example.model.Book;
import org.example.enums.BorrowItemStatus;
import org.example.model.LibraryItem;
import org.example.model.Move;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private static final List<LibraryItem> database = new ArrayList<>();
    private static boolean initialized = false;

    public LibraryService() {
        initLibrary();
    }

    private void initLibrary() {
        if (initialized) {
            return;
        }
        database.add(new Book("Wilk Stepowy", "Hasse", 258));
        database.add(new Book("Pszczółka Maja", "Autor", 123));
        database.add(new Book("Noname", "NoName", 222));
        database.add(new Move("Wilk z Wall Street", "Martin Scorsese", 143));
        database.add(new Move("Openheimer", "Johny Deep", 183));
        initialized = true;
    }

    public void displayLibraryItems() {
        System.out.println("\tLista elementów dostępnych");
        displayItemsByStatus(BorrowItemStatus.AVALIABLE);

        System.out.println("\tLista elementów wypożyczonych");
        displayItemsByStatus(BorrowItemStatus.BORROWABLE);
    }

    private void displayItemsByStatus(BorrowItemStatus status) {
        for (LibraryItem item : database) {
            if (item.getStatus() == status) {
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
        if (findItem.getStatus() == BorrowItemStatus.AVALIABLE) {
            findItem.setStatus(BorrowItemStatus.BORROWABLE);
            return findItem;
        }
        throw new BorrowedItemExeption(String.format("Tytuł: '%s' - jest wypożyczony", title));
    }

    public LibraryItem findItemByTitle(String title) {
        for (LibraryItem item : database) {
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
        if (findItem.getStatus() == BorrowItemStatus.BORROWABLE) {
            findItem.setStatus(BorrowItemStatus.AVALIABLE);
            return;
        }
        throw new ItemNotBorrowedExeption(String.format("Tytuł: '%s' - nie był wypożyczony", title));
    }
}
