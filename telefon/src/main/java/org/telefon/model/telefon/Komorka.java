package org.telefon.model.telefon;

import org.telefon.exeption.PhoneCallHistoryyFullExeption;
import org.telefon.exeption.PhoneNumberIsOfflineException;
import org.telefon.model.operator.Operator;

import java.awt.*;

public class Komorka extends Telefon {
    protected final static int SIZE_OF_CALL_HISTORY = 10;
    protected String[] polaczennia = new String[SIZE_OF_CALL_HISTORY];
    protected int pozycjaPolaczenia = 0;

    private void addCalltoHistory(String number) throws PhoneCallHistoryyFullExeption {
        isCallHistoryFull();
        polaczennia[pozycjaPolaczenia++] = number;
    }

    private void isCallHistoryFull() throws PhoneCallHistoryyFullExeption {
        if (pozycjaPolaczenia >= SIZE_OF_CALL_HISTORY) {
            throw new PhoneCallHistoryyFullExeption("Lista połączeń przepełniona");
        }
    }

    public Komorka(String interfejsKomunikacyjny, Color color, Operator operator) {
        super(interfejsKomunikacyjny, color, operator);
    }

    @Override
    public void odbierz(String numerTelefonu) throws PhoneCallHistoryyFullExeption {
        addCalltoHistory(numerTelefonu);
    }

    @Override
    public void zadzwon(String numerTelefonu) throws PhoneNumberIsOfflineException, NumberFormatException, PhoneCallHistoryyFullExeption {
        isCallHistoryFull();
        if (!isConected()) {
            throw new PhoneNumberIsOfflineException(String.format("Numer %s - jest po za zasiegiem", numerTelefonu));
        }

        try {
            operator.dzwonNaNumer(this.interfejsKomunikacyjny, numerTelefonu);
            addCalltoHistory(numerTelefonu);
        } catch (PhoneNumberIsOfflineException e) {
            System.err.printf("Numer telefonu %s - jest nieosiągalny", numerTelefonu);
        }
    }
}
