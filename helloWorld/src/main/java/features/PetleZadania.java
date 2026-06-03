package features;

import java.util.Scanner;

public class PetleZadania {
    public static void main(String[] args) {
        int weight, height;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Rysowanie prostokąta: ");
        System.out.print("Podaj wysokość: ");
        height = scanner.nextInt();
        System.out.print("Podaj szerokość: ");
        weight = scanner.nextInt();

        drawRectangle(weight, height);

        drawPiramideint(height);

        task3Matrix3_3();

        System.out.println("\nTesty dla funkcji sprawdzającej unikalność znaków");
        String testString1 = "password123";
        System.out.println("Text: '" + testString1 + "' wynik: " +
                validateUniqueCharactersInPassword(testString1)
                );
        String testString2 = "pas$word123";
        System.out.println("Text: '" + testString2 + "' wynik: " +
                validateUniqueCharactersInPassword(testString2)
        );
    }

    private static void drawRectangle(int weight, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {
                if( i == 0 || j ==0 || i == (height-1) || j == (weight-1)) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }

    private static void drawPiramideint(int height) {
        for (int i = 0; i < height; i++) {
            System.out.println(" ".repeat((height - i) - 1) + "*".repeat(i * 2 + 1));
        }
    }


    static private final int SIZE_ARRAY = 3;

    static private void task3Matrix3_3() {
        int[][] array = new int[SIZE_ARRAY][SIZE_ARRAY];

        for (int i = 0; i < SIZE_ARRAY; i++) {
            for (int j = 0; j < SIZE_ARRAY; j++) {
                array[i][j] = SIZE_ARRAY * i + j + 1;
            }
        }

        printArray(array);
    }

    static private void printArray(int[][] array) {
        for (int i = 0; i < SIZE_ARRAY; i++) {
            for (int j = 0; j < SIZE_ARRAY; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    static public boolean validateUniqueCharactersInPassword(String password) {
        char[] characters = new char[password.length()];

        for (int i = 0; i < password.length(); i++) {
            char letter = password.charAt(i);
            characters[i] = letter;
            for (int j = 0; j < i; j++) {
                if( letter == characters[j]  ) {
                    return false;
                }
            }
        }
        return true;
    }

}
