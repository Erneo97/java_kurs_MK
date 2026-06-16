package org.example;

import org.example.libraryItems.LibraryItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        LibraryInterface libraryInterface = new LibraryInterface();
        libraryInterface.initLibrary();

        int selectedAction = 1;
        Scanner input = new Scanner(System.in);

        while ( selectedAction != 5 ) {
            System.out.print("""
                Dostępne akcje:
                1- Wyświetlanie listy dostępnych i wypożyczonych elementów.
                2 - Wypożyczanie elementu po tytule.
                3 - Zwracanie elementu po tytule.
                4 - Wyświetlanie liczby książek i filmów w systemie.
                5 - Wyjście z programu.
                Twój wybór: """);
            selectedAction = input.nextInt();

        }
        // zw, bo w rpacy jestem i jest sprawa do zrobienia
    }


}