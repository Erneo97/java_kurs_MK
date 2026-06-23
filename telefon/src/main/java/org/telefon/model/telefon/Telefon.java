package org.telefon.model.telefon;

import org.telefon.exeption.NumberFormatExeption;
import org.telefon.exeption.PhoneCallHistoryyFullExeption;
import org.telefon.exeption.PhoneNumberAlredyExistsExeption;
import org.telefon.exeption.PhoneNumberIsOfflineException;
import org.telefon.model.operator.Operator;

import java.awt.*;
import java.util.Objects;

public abstract class Telefon {
    // POLA KLASY
    protected String interfejsKomunikacyjny;
    protected Color color;
    protected Operator operator;
    private boolean conected;

    // KONSTRUKTORY
    public Telefon(String interfejsKomunikacyjny, Color color, Operator operator) {
        this.interfejsKomunikacyjny = interfejsKomunikacyjny;
        this.color = color;
        this.operator = operator;

        tryToConnect();
    }

    // METODY ABSTRAKCYJNE
    public abstract void odbierz(String numerTelefonu) throws PhoneCallHistoryyFullExeption;

    public abstract void zadzwon(String numerTelefonu) throws PhoneNumberIsOfflineException, PhoneCallHistoryyFullExeption, NumberFormatExeption;

    public abstract void wyswietlHistoriePolaczen();

    // METODY PUBLICZNE
    public String getInterfejsKomunikacyjny() {
        return interfejsKomunikacyjny;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Telefon telefon = (Telefon) o;
        return Objects.equals(interfejsKomunikacyjny, telefon.interfejsKomunikacyjny) && Objects.equals(color, telefon.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(interfejsKomunikacyjny, color);
    }

    public boolean isConected() {
        return conected;
    }

    // METODY POMOCNICZE (private / protected)
    protected final void tryToConnect() {
        try {
            operator.dodajTelefon(this);
            conected = true;
        } catch (PhoneNumberAlredyExistsExeption e) {
            conected = false;
        }
    }
}
