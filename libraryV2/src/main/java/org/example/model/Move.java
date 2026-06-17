package org.example.model;

public class Move extends LibraryItem {
    private static int moveCounter = 0;

    public Move(String title, String director, int lengthMinutes) {
        super(title, director, lengthMinutes);
        moveCounter++;
    }

    public static int getMoveCounter() {
        return moveCounter;
    }

    @Override
    public String toString() {
        return "Film{" +
                "tytuł='" + title + '\'' +
                ", autoryser='" + autor + '\'' +
                ", długość (min.)=" + length +
                '}';
    }
}
