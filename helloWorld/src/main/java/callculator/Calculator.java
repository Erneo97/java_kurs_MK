package callculator;

import java.util.Scanner;

public class Calculator {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        double wynik = 0.0;

        String inputExpression;
        char operator = ' ';

        Scanner scanner = new Scanner(System.in);

        System.out.println("Prosty kalkulator.");

        while (operator != 'n' || Double.isNaN(wynik)) {
            System.out.print("Podaj wyrażenie: ");
            inputExpression = scanner.nextLine();

            var elementExpression = inputExpression.split(" ");

            if (!isCorrectExpression(elementExpression)) {
                continue;
            }
            operator = elementExpression[1].charAt(0);

            wynik = getResultMathematicOperation(
                    Double.parseDouble(elementExpression[0]),
                    Double.parseDouble(elementExpression[2]), operator);
            System.out.println("Wynik: " + (Double.isNaN(wynik) ? "Błędna operacja" : wynik));

            System.out.print("Chce wykonać kolejne działanie (y/n)?   ");
            operator = scanner.nextLine().charAt(0);
        }

        System.out.println("Ostatni wynik jest " + (wynik % 2 == 0 ? "parzysty." : "nieparzysty."));
    }

    private static boolean isCorrectExpression(String[] str) {
        if (str.length < 3) {
            errorMessage("Wyrażenie nie dokończone. - Musi mieć postać 'num op num'");
            return false;
        }

        if (!str[1].matches("[-+/*^%]")) {
            errorMessage("Dozwolone operacje matematyczne +, -, *, /, ^, %");
            return false;
        }

        if (!isNumeric(str[0]) || !isNumeric(str[2])) {
            errorMessage("Nie można wykonać działania matematycznego bez dwóch liczb.");
            return false;
        }

        return true;
    }

    static private void errorMessage(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }


    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    @Deprecated
    private static double getNumberFromUser(Scanner scanner) {
        double returnNumber = scanner.nextDouble();
        scanner.nextLine();
        return returnNumber;
    }

    private static Double getResultMathematicOperation(double num1, double num2, char operator) {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> {
                if (num2 == 0) {
                    errorMessage("Nie można dzielić przez 0");
                    yield Double.NaN;
                }

                yield num1 / num2;
            }
            case '%' -> num1 % num2;
            case '^' -> Math.pow(num1, num2);

            default -> Double.NaN;
        };
    }

}
