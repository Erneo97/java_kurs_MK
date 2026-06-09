package org.example;

import listaZDowiazaniami.LIFO;
import listaZDowiazaniami.Point;

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


        System.out.println("\n\tTest dla lifo point");

        LIFO<Point> lifoPoint = new LIFO<>();

        for (int i = 0; i <= 10; i++) {
            lifoPoint.add(new Point(i * 2.0, i * 3.0));
            System.out.printf("%s  - %d %n", lifoPoint, lifoPoint.size());
        }

        System.out.println("testy dla remove");
        lifoPoint.remove(new Point(0.0, 0.0));
        System.out.printf("%s  - %d %n", lifoPoint, lifoPoint.size());

        lifoPoint.remove(new Point(2.0, 3.0));
        System.out.printf("%s  - %d %n", lifoPoint, lifoPoint.size());

        lifoPoint.remove(new Point(20.0, 30.0));
        System.out.printf("%s  - %d %n", lifoPoint, lifoPoint.size());

        System.out.print("\nSilnia: " + factiorial(25));

    }

    static private int factiorial(int n) {
        if (n <= 0) { // warunek stopu
            return 1;
        }
        return n * factiorial(n - 1); // krok rekurencyjny
    }
}