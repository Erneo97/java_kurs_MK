package org.telefon.model.telefon;

import org.telefon.exeption.PhoneNumberAlredyExistsExeption;
import org.telefon.model.operator.Operator;

import java.awt.*;
import java.util.Objects;

public abstract class Telefon{
    protected String interfejsKomunikacyjny;
    protected Color color;
    Operator operator;
    boolean conected;

    public Telefon(String interfejsKomunikacyjny, Color color, Operator operator){
        this.interfejsKomunikacyjny = interfejsKomunikacyjny;
        this.color = color;
        this.operator = operator;

        try {
            operator.dodajTelefon(this);
            conected = true;
        } catch (PhoneNumberAlredyExistsExeption e) {
            conected = false;
        }
    }

    private void tryToConnect() {
        try {
            operator.dodajTelefon(this);
            conected = true;
        } catch (PhoneNumberAlredyExistsExeption e) {
            conected = false;
        }
    }

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

    public abstract void odbierz(String numerTelefonu);
}
