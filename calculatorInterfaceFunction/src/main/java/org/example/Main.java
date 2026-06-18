package org.example;

import org.example.enums.AvaliableMathOperations;
import org.example.interfaces.MathOperation;

public class Main {
    public static void main(String[] args) {
        int number1 = 5, number2 = 2;

        MathOperation add = Integer::sum;
        MathOperation sub = (a, b) -> a - b;
        MathOperation multiply = (a, b) -> a * b;
        MathOperation divide = (a, b) -> {
            if (b == 0) {
                throw new ArithmeticException();
            }
            return a / b;
        };

        System.out.println("\tTest interfejs funkcyjny");
        System.out.printf("Dodawanie: %d\n", calculate(number1, number2, add));
        System.out.printf("Odejmowanie: %d\n", calculate(number1, number2, sub));
        System.out.printf("Mnożenie: %d\n", calculate(number1, number2, multiply));
        System.out.printf("Dzielenie: %d\n", calculate(number1, number2, divide));

        System.out.println("\tTest enum");
        System.out.printf("Dodawanie: %d\n", AvaliableMathOperations.getMathOperation("+").calculate(number1, number2));
        System.out.printf("Odejmowanie: %d\n", AvaliableMathOperations.getMathOperation("-").calculate(number1, number2));
        System.out.printf("Mnożenie: %d\n", AvaliableMathOperations.getMathOperation("*").calculate(number1, number2));
        System.out.printf("Dzielenie: %d\n", AvaliableMathOperations.getMathOperation("/").calculate(number1, number2));

    }

    public static int calculate(int a, int b, MathOperation operation) {
        return operation.calculate(a, b);
    }

}