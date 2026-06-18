package org.example.enums;

public enum StringsDefaultFormatExeptions {
    ITEM_NOT_EXIST("Tytuł: '%s' nie jest częścią biblioteki"),
    BORROW_NOT_BOROWWED("Tytuł: '%s' - nie był wypożyczony"),
    BORROWED_ITEM("Tytuł: '%s' - jest wypożyczony");

    private final String format;

    StringsDefaultFormatExeptions(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
