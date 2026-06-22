package org.telefon.model.telefon;

import org.telefon.exeption.PhoneCallHistoryyFullExeption;
import org.telefon.exeption.PhoneNumberIsOfflineException;
import org.telefon.model.operator.Operator;

import java.awt.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class Komorka extends Telefon {
    protected final static int SIZE_OF_CALL_HISTORY = 10;
    protected String[] polaczennia = new String[SIZE_OF_CALL_HISTORY];
    protected int pozycjaPolaczenia = 0;

    private void addCalltoHistory(String number) throws PhoneCallHistoryyFullExeption {
        isCallHistoryFull();
        polaczennia[pozycjaPolaczenia++] = number;
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
        if (!isCorretNumberFormat(numerTelefonu)) {
            throw new NumberFormatException(String.format("Zły format numeru telefonu %s - powinnien być XXX-XXX-XXX", numerTelefonu));
        }

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

    @Override
    public void wyswietlHistoriePolaczen() {
        System.out.printf("Wyswietl historie %s (%s)\n", this.getClass().getSimpleName(), this.getInterfejsKomunikacyjny());
        getPolaczeniaStream()
                .forEach(numer -> System.out.printf("\t%s\n", numer));
    }

    protected Stream<String> getPolaczeniaStream() {
        return Arrays.stream(polaczennia)
                .filter(Objects::nonNull);
    }

    private boolean isCorretNumberFormat(String number) {
        return number.matches("\\d{3}-\\d{3}-\\d{3}");
    }

    private void isCallHistoryFull() throws PhoneCallHistoryyFullExeption {
        if (pozycjaPolaczenia >= SIZE_OF_CALL_HISTORY) {
            throw new PhoneCallHistoryyFullExeption("Lista połączeń przepełniona");
        }
    }
}
