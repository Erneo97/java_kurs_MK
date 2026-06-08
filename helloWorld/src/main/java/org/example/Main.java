package org.example;

import features.LIFO;

import java.util.Locale;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LIFO lifo = new LIFO();

        for (int i = 1; i <= 10; i++) {
            lifo.add(i * 10);
            System.out.printf("%s  - %d %n", lifo, lifo.size());
        }

        System.out.println("testy dla remove");
        lifo.remove(100);
        System.out.printf("%s  - %d %n", lifo, lifo.size());

        lifo.remove(40);
        System.out.printf("%s  - %d %n", lifo, lifo.size());

        lifo.remove(10);
        System.out.printf("%s  - %d %n", lifo, lifo.size());


//        for (int i = 1; i <= 10 ; i++) {
//            lifo.pop( );
//            System.out.printf("%s  - %d %n", lifo, lifo.size() );
//        }


//        double d = 12311145.6789;
//        String s = String.format("wartosc  %1$,10.2f", d);
//
//        System.out.println("Formatted Price: " + s);
//
//        double d2 = 11145.6789;
//        s = String.format(Locale.ITALIAN, "%2$,10.2f \t%1$,10.2f", d2, d); // formatowanie pozwala zmienić separator na kropkę przecinek co 3 cyfry
//        System.out.printf("Formatted Price: %S%n", s);
//
//        for (int i = 0; i < 10; i++) {
//            System.out.printf("%1$d   -   %1$B%n", i);
//        }

    }
}