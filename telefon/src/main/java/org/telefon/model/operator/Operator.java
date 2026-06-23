package org.telefon.model.operator;

import org.telefon.exeption.PhoneCallHistoryyFullExeption;
import org.telefon.exeption.PhoneNumberAlredyExistsExeption;
import org.telefon.exeption.PhoneNumberIsOfflineException;
import org.telefon.model.telefon.Telefon;

public interface Operator {
    void dodajTelefon(Telefon telefon) throws PhoneNumberAlredyExistsExeption;

    void usunTelefon(Telefon telefon);

    void dzwonNaNumer(String numerDzwonicay, String numerOdbierajacy) throws PhoneNumberIsOfflineException, PhoneCallHistoryyFullExeption;
}
