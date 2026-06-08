package org.example;

import features.LIFO;

import java.util.Locale;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LIFO<Integer> lifoInteger = new LIFO<>();

        for (int i = 1; i <= 10; i++) {
            lifoInteger.add(i * 10);
            System.out.printf("%s  - %d %n", lifoInteger, lifoInteger.size());
        }

        System.out.println("testy dla remove");
        lifoInteger.remove(100);
        System.out.printf("%s  - %d %n", lifoInteger, lifoInteger.size());

        lifoInteger.remove(40);
        System.out.printf("%s  - %d %n", lifoInteger, lifoInteger.size());

        lifoInteger.remove(10);
        System.out.printf("%s  - %d %n", lifoInteger, lifoInteger.size());


        System.out.println("\n\tTest dla lifo double");

        LIFO<Double> lifoDouble = new LIFO<>();

        for (int i = 1; i <= 10; i++) {
            lifoDouble.add(i * 100.0);
            System.out.printf("%s  - %d %n", lifoDouble, lifoDouble.size());
        }

        System.out.println("testy dla remove");
        lifoDouble.remove(1000.0);
        System.out.printf("%s  - %d %n", lifoDouble, lifoDouble.size());

        lifoDouble.remove(400.0);
        System.out.printf("%s  - %d %n", lifoDouble, lifoDouble.size());

        lifoDouble.remove(100.0);
        System.out.printf("%s  - %d %n", lifoDouble, lifoDouble.size());


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