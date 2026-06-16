package org.example;

import org.example.exeptions.BorrowedItem;
import org.example.exeptions.ItemNotBorrowed;
import org.example.exeptions.ItemNotExist;
import org.example.libraryItems.LibraryItem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LibraryInterface libraryInterface = new LibraryInterface();
        libraryInterface.initLibrary();

        int selectedAction = 1;
        Scanner input = new Scanner(System.in);

        while (selectedAction != 5) {
            System.out.print("""
                    Dostępne akcje:
                    1- Wyświetlanie listy dostępnych i wypożyczonych elementów.
                    2 - Wypożyczanie elementu po tytule.
                    3 - Zwracanie elementu po tytule.
                    4 - Wyświetlanie liczby książek i filmów w systemie.
                    5 - Wyjście z programu.
                    Twój wybór:""");
            selectedAction = input.nextInt();
            input.nextLine();
            switch (selectedAction) {
                case 1 -> libraryInterface.displayLibraryItems();
                case 2 -> borrowItemByTitle(libraryInterface, input);
                case 3 -> returnItemByTitle(libraryInterface, input);
                case 4 -> libraryInterface.displayCountBookAndMovie();
                case 5 -> System.out.println("Do widzenia");
            }
            System.out.println();
        }
    }

    static void borrowItemByTitle(LibraryInterface libraryInterface, Scanner input) {
        System.out.print("Podaj tytuł do wypożyczenia: ");
        String title = input.nextLine();
        try {
            LibraryItem item = libraryInterface.borrowItemByTitle(title);
            System.out.println("Wypożyczono " + item.getClass().getSimpleName());
        } catch (ItemNotExist | BorrowedItem e) {
            System.err.println(e.getMessage());
        }
    }

    static void returnItemByTitle(LibraryInterface libraryInterface, Scanner input) {
        System.out.print("Podaj tytuł do wypożyczenia: ");
        String title = input.nextLine();
        try {
            libraryInterface.returnItemByTitle(title);
            System.out.println("Oddano pomyślnie " + title);
        } catch (ItemNotExist | ItemNotBorrowed e) {
            System.err.println(e.getMessage());
        }
    }
}