package org.example.enums;

public enum LibraryServiceActions {
    DISPLAY_LIBRARY_ITEMS(1),
    BORROW_LIBRARY_ITEMS(2),
    RETURN_LIBRARY_ITEMS(3),
    DISPLAY_COUNTS_ITEMS(4),
    EXIT(5),
    NON_EXIST_ACTION(-1);

    private final int action;

    LibraryServiceActions(int action) {
        this.action = action;
    }

    public static LibraryServiceActions getActionByNumber(int action) {
        for (LibraryServiceActions item : LibraryServiceActions.values()) {
            if (item.action == action) {
                return item;
            }
        }
        return NON_EXIST_ACTION;
    }

}
