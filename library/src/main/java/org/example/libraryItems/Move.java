package org.example.libraryItems;

public class Move extends LibraryItem {
    private static int moveCounter = 0;

    public Move(String title, String autor, int lenght) {
        super(title, autor, lenght);
        moveCounter++;
    }

    public static int getMoveCounter() {
        return moveCounter;
    }

    @Override
    public String toString() {
        return "Move{" +
                "title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                ", lenght=" + lenght +
                '}';
    }
}
