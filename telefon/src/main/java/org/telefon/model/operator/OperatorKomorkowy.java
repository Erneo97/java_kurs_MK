package org.telefon.model.operator;

import org.telefon.model.telefon.Telefon;

import java.util.HashMap;
import java.util.Map;

public class OperatorKomorkowy implements Operator {
    Map<String, Telefon> telefonyWSieci = new HashMap<>();

    @Override
    public void dodajTelefon(Telefon telefon) {

    }

    @Override
    public void usunTelefon(Telefon telefon) {

    }

    @Override
    public void dzwonNaNumer(String numer) {

    }
}
