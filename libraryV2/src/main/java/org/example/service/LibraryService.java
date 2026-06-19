package org.example.service;

import org.example.enums.StringsDefaultFormatExeptions;
import org.example.exeptions.BorrowedItemExeption;
import org.example.exeptions.ItemNotBorrowedExeption;
import org.example.exeptions.ItemNotExist;
import org.example.model.Book;
import org.example.enums.BorrowItemStatus;
import org.example.model.LibraryItem;
import org.example.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        database.add(new Movie("Wilk z Wall Street", "Martin Scorsese", 143));
        database.add(new Movie("Openheimer", "Johny Deep", 183));
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
        System.out.printf("Liczba książek: %d\nLiczba filmów: %d\n", Book.getBookCounter(), Movie.getMoveCounter());
    }

    public LibraryItem borrowItemByTitle(String title) throws BorrowedItemExeption {
        Optional<LibraryItem> findItem = findItemByTitle(title);
        LibraryItem item = findItem.orElseThrow(() -> new ItemNotExist(
                String.format(StringsDefaultFormatExeptions.ITEM_NOT_EXIST.getFormat(), title)));
        item.borrow();
        return item;
    }

    public Optional<LibraryItem> findItemByTitle(String title) {
        for (LibraryItem item : database) {
            if (item.getTitle().equals(title)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    public void returnItemByTitle(String title) throws ItemNotBorrowedExeption {
        Optional<LibraryItem> findItem = findItemByTitle(title);
        LibraryItem item = findItem.orElseThrow(() -> new ItemNotExist(
                String.format(StringsDefaultFormatExeptions.ITEM_NOT_EXIST.getFormat(), title)));
        item.returnBorrowedItem();
    }
}
