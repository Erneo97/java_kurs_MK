package org.example;

import org.example.enums.LibraryInterfaceActions;
import org.example.exeptions.BorrowedItem;
import org.example.exeptions.ItemNotBorrowed;
import org.example.exeptions.ItemNotExist;
import org.example.libraryItems.LibraryItem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryInterface libraryInterface = new LibraryInterface();
        libraryInterface.initLibrary();
        LibraryInterfaceActions selectedAction = LibraryInterfaceActions.NON_EXIST_ACTION;
        Scanner input = new Scanner(System.in);

        System.out.println("Witamy w bibliotece");
        while (selectedAction != LibraryInterfaceActions.EXIT) {
            System.out.print("""
                    Dostępne akcje:
                    1- Wyświetlanie listy dostępnych i wypożyczonych elementów.
                    2 - Wypożyczanie elementu po tytule.
                    3 - Zwracanie elementu po tytule.
                    4 - Wyświetlanie liczby książek i filmów w systemie.
                    5 - Wyjście z programu.
                    Twój wybór:""");
            int numbrAction = input.nextInt();
            input.nextLine();
            selectedAction = LibraryInterfaceActions.getActionByNumber(numbrAction);
            handleAction(selectedAction, libraryInterface, input);
        }
    }

    protected static void handleAction(LibraryInterfaceActions action, LibraryInterface libraryInterface, Scanner input) {
        switch (action) {
            case DISPLAY_LIBRARY_ITEMS -> libraryInterface.displayLibraryItems();
            case BORROW_LIBRARY_ITEMS -> borrowItemByTitle(libraryInterface, input);
            case RETURN_LIBRARY_ITEMS -> returnItemByTitle(libraryInterface, input);
            case DISPLAY_COUNTS_ITEMS -> libraryInterface.displayCountBookAndMovie();
            case EXIT -> System.out.println("Do widzenia");
            default -> System.err.println("Nie istnieje taka akcja");
        }
        System.out.println();
    }

    protected static void borrowItemByTitle(LibraryInterface libraryInterface, Scanner input) {
        System.out.print("Podaj tytuł do wypożyczenia: ");
        String title = input.nextLine();
        try {
            LibraryItem item = libraryInterface.borrowItemByTitle(title);
            System.out.println("Wypożyczono: " + item.getClass().getSimpleName());
        } catch (ItemNotExist | BorrowedItem e) {
            System.err.println(e.getMessage());
        }
    }

    protected static void returnItemByTitle(LibraryInterface libraryInterface, Scanner input) {
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