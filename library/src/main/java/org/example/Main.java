package org.example;

import org.example.enums.LibraryInterfaceActions;
import org.example.exeptions.BorrowedItem;
import org.example.exeptions.ItemNotBorrowed;
import org.example.exeptions.ItemNotExist;
import org.example.libraryItems.LibraryItem;

import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final LibraryInterface libraryInterface = new LibraryInterface();

    public static void main(String[] args) {
        LibraryInterfaceActions selectedActionLibraryInterface = LibraryInterfaceActions.NON_EXIST_ACTION;

        System.out.println("Witamy w bibliotece");
        while (selectedActionLibraryInterface != LibraryInterfaceActions.EXIT) {
            System.out.print("""
                    Dostępne akcje:
                    1- Wyświetlanie listy dostępnych i wypożyczonych elementów.
                    2 - Wypożyczanie elementu po tytule.
                    3 - Zwracanie elementu po tytule.
                    4 - Wyświetlanie liczby książek i filmów w systemie.
                    5 - Wyjście z programu.
                    Twój wybór:""");
            int selectedAction = input.nextInt();
            input.nextLine();
            selectedActionLibraryInterface = LibraryInterfaceActions.getActionByNumber(selectedAction);
            handleAction(selectedActionLibraryInterface);
        }
    }

    private static void handleAction(LibraryInterfaceActions action) {
        switch (action) {
            case DISPLAY_LIBRARY_ITEMS -> libraryInterface.displayLibraryItems();
            case BORROW_LIBRARY_ITEMS -> borrowItemByTitle();
            case RETURN_LIBRARY_ITEMS -> returnItemByTitle();
            case DISPLAY_COUNTS_ITEMS -> libraryInterface.displayCountBookAndMovie();
            case EXIT -> System.out.println("Do widzenia");
            default -> System.err.println("Nie istnieje taka akcja");
        }
        System.out.println();
    }

    private static void borrowItemByTitle() {
        System.out.print("Podaj tytuł do wypożyczenia: ");
        String title = input.nextLine();
        try {
            LibraryItem item = libraryInterface.borrowItemByTitle(title);
            System.out.println("Wypożyczono: " + item.getClass().getSimpleName());
        } catch (ItemNotExist | BorrowedItem e) {
            System.err.println(e.getMessage());
        }
    }

    private static void returnItemByTitle() {
        System.out.print("Podaj tytuł do wypożyczenia: ");
        String title = input.nextLine();
        try {
            libraryInterface.returnItemByTitle(title);
            System.out.println("Oddano pomyślnie: " + title);
        } catch (ItemNotExist | ItemNotBorrowed e) {
            System.err.println(e.getMessage());
        }
    }
}