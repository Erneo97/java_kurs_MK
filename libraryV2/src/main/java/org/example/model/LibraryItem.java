package org.example.model;

import org.example.enums.BorrowItemStatus;
import org.example.exeptions.BorrowedItemExeption;
import org.example.exeptions.ItemNotBorrowedExeption;
import org.example.interfaces.Borowlable;

import java.util.Objects;

public abstract class LibraryItem {
    protected final String title;
    protected final String autor;
    protected final int length;
    private BorrowItemStatus status = BorrowItemStatus.AVALIABLE;

    public BorrowItemStatus getStatus() {
        return status;
    }

    public void borrow() throws BorrowedItemExeption {
        if (status == BorrowItemStatus.BORROWABLE) {
            throw new BorrowedItemExeption(String.format("Tytuł: '%s' - jest wypożyczony", title));
        }
        this.status = BorrowItemStatus.BORROWABLE;
    }

    public void returnBorowedItem() throws ItemNotBorrowedExeption {
        if (status == BorrowItemStatus.AVALIABLE) {
            throw new ItemNotBorrowedExeption(String.format("Tytuł: '%s' - nie był wypożyczony", title));
        }
        this.status = BorrowItemStatus.AVALIABLE;
    }

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
