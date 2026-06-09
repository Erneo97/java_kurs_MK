package org.example;

import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static HashMap<Integer, Integer> fibonacciNumbers = new HashMap<>();

    public static void main(String[] args) {
        System.out.print("\nSilnia: " + factiorial(25));

        System.out.print("\nFibonacci: " + fibonacci(0));
        System.out.print("\nFibonacci: " + fibonacci(1));
        System.out.print("\nFibonacci: " + fibonacci(5));
        System.out.print("\nFibonacci: " + fibonacci(19));
        System.out.print("\nFibonacci: " + fibonacci(120));
    }

    static private void updateFibonacciNumber(Integer n, Integer value) {
        fibonacciNumbers.put(n, value);
    }

    static private boolean isNumberSaved(Integer n) {
        return fibonacciNumbers.containsKey(n);
    }

    static private Integer getFibbonacciNumber(Integer n) {
        if (!isNumberSaved(n)) {
            updateFibonacciNumber(n, fibonacci(n));
        }
        return fibonacciNumbers.get(n);
    }

    static public Integer fibonacci(Integer n) {
        if (n <= 0) {
            updateFibonacciNumber(n, 0);
            return 0;
        }
        if (n == 1) {
            updateFibonacciNumber(n, 1);
            return 1;
        }
        return getFibbonacciNumber(n - 2) + getFibbonacciNumber(n - 1);
    }

    static public long factiorial(long n) {
        if (n <= 0) { // warunek stopu
            return 1;
        }
        return n * factiorial(n - 1); // krok rekurencyjny
    }

}