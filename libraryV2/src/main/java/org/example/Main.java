package org.example;

import org.example.enums.LibraryServiceActions;
import org.example.exeptions.BorrowedItemExeption;
import org.example.exeptions.ItemNotBorrowedExeption;
import org.example.exeptions.ItemNotExist;
import org.example.model.LibraryItem;
import org.example.service.LibraryService;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final LibraryService LibraryService = new LibraryService();

    public static void main(String[] args) {
        LibraryServiceActions selectedActionLibraryService = LibraryServiceActions.NON_EXIST_ACTION;

        System.out.println("Witamy w bibliotece");
        while (selectedActionLibraryService != LibraryServiceActions.EXIT) {
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
            selectedActionLibraryService = LibraryServiceActions.getActionByNumber(selectedAction);
            handleAction(selectedActionLibraryService);
        }
    }

    private static void handleAction(LibraryServiceActions action) {
        switch (action) {
            case DISPLAY_LIBRARY_ITEMS -> LibraryService.displayLibraryItems();
            case BORROW_LIBRARY_ITEMS -> borrowItemByTitle();
            case RETURN_LIBRARY_ITEMS -> returnItemByTitle();
            case DISPLAY_COUNTS_ITEMS -> LibraryService.displayCountBookAndMovie();
            case EXIT -> System.out.println("Do widzenia");
            default -> System.err.println("Nie istnieje taka akcja");
        }
        System.out.println();
    }

    private static void borrowItemByTitle() {
        System.out.print("Podaj tytuł do wypożyczenia: ");
        String title = input.nextLine();
        try {
            LibraryItem item = LibraryService.borrowItemByTitle(title);
            System.out.println("Wypożyczono: " + item.getClass().getSimpleName());
        } catch (ItemNotExist | BorrowedItemExeption e) {
            System.err.println(e.getMessage());
        }
    }

    private static void returnItemByTitle() {
        System.out.print("Podaj tytuł do wypożyczenia: ");
        String title = input.nextLine();
        try {
            LibraryService.returnItemByTitle(title);
            System.out.println("Oddano pomyślnie: " + title);
        } catch (ItemNotExist | ItemNotBorrowedExeption e) {
            System.err.println(e.getMessage());
        }
    }
}