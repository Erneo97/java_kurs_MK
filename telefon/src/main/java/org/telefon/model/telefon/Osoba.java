package org.telefon.model.telefon;

public record Osoba (String imie, String nazwisko, String numer) {
    @Override
    public String toString() {
        return String.format("%s %s %s",  imie, nazwisko, numer);
    }
}
