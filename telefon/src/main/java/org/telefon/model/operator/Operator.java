package org.telefon.model.operator;

import org.telefon.model.telefon.Telefon;

public interface Operator {
    void dodajTelefon(Telefon telefon);
    void usunTelefon(Telefon telefon);
    void dzwonNaNumer(String numer);
}
