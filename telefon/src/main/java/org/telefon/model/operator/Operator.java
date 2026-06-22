package org.telefon.model.operator;

import org.telefon.exeption.PhoneNumberIsOfflineExeption;
import org.telefon.model.telefon.Telefon;

public interface Operator {
    void dodajTelefon(Telefon telefon) throws PhoneNumberIsOfflineExeption;
    void usunTelefon(Telefon telefon);
    void dzwonNaNumer(String numer) throws PhoneNumberIsOfflineExeption;
}
