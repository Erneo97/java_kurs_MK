package callculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        double liczba1, liczba2;
        Double wynik = 0.0;
        char operator = ' ';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Proszty kalkulator.");
        while( operator != 'n' || Double.isNaN(wynik)) {
            System.out.print("Podaj liczbę: ");
            liczba1 = getNumberFromUser(scanner);

            System.out.print("Podaj liczbę: ");
            liczba2 = getNumberFromUser(scanner);

            System.out.print("Podaj operator: ");
            operator = scanner.nextLine().charAt(0);

            wynik =  getResultMathematicOperation(liczba1, liczba2, operator);
            System.out.println("Wynik: " + (wynik.equals(Double.NaN) ? "Błędna operacja" : wynik)  );

            System.out.print("Chce wykonać kolejne działanie (y/n)?   ");
            operator = scanner.nextLine().charAt(0);
        }

        System.out.println("Ostatni wynik jest " + ( wynik % 2 == 0 ? "parzysty." : "nieparzysty.") );

    }

    private static double getNumberFromUser(Scanner scanner) {
        double returnNumber = scanner.nextDouble();
        scanner.nextLine();
       return returnNumber;
    }

    private static Double getResultMathematicOperation(double num1, double num2, char operator) {
        return switch( operator ) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> {
                if( num2 == 0 ) {
                    yield Double.NaN;
                }
                else {
                    yield  num1 / num2;
                }
            }
            case '%' -> num1 % num2;
            case '^' -> Math.pow(num1, num2);

            default -> Double.NaN;
        };
    }

}
