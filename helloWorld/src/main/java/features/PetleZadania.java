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
    }

    private static void drawRectangle(int weight, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {
                System.out.print("*");
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

}
