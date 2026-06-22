package org.telefon.model.operator;

import org.telefon.exeption.PhoneNumberIsOfflineExeption;
import org.telefon.model.telefon.Telefon;

import java.util.HashMap;
import java.util.Map;

public class OperatorKomorkowy implements Operator {
    Map<String, Telefon> telefonyWSieci = new HashMap<>();

    @Override
    public void dodajTelefon(Telefon telefon) throws PhoneNumberIsOfflineExeption {

    }

    @Override
    public void usunTelefon(Telefon telefon) {

    }

    @Override
    public void dzwonNaNumer(String numer) throws PhoneNumberIsOfflineExeption {

    }
}
