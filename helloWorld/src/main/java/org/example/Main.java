package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        double liczba1, liczba2;
        char operator = ' ';
        Scanner scanner = new Scanner(System.in);


        do {
            System.out.print("Podaj liczbę: ");
            liczba1 = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Podaj liczbę: ");
            liczba1 = scanner.nextDouble();
            scanner.nextLine();


        }while( operator != 'e'  );

    }
}