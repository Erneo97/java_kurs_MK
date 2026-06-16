package org.example.enums;

public enum LibraryInterfaceActions {
    DISPLAY_LIBRARY_ITEMS(1),
    BORROW_LIBRARY_ITEMS(2),
    RETURN_LIBRARY_ITEMS(3),
    DISPLAY_COUNTS_ITEMS(4),
    EXIT(5),
    NON_EXIST_ACTION(-1);

    private final int action;

    LibraryInterfaceActions(int action) {
        this.action = action;
    }

    public static LibraryInterfaceActions getActionByNumber(int action) {
        for (LibraryInterfaceActions item : LibraryInterfaceActions.values()) {
            if (item.action == action) {
                return item;
            }
        }
        return NON_EXIST_ACTION;
    }

}
