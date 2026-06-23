package org.telefon.model.operator;

import org.telefon.exeption.PhoneCallHistoryyFullExeption;
import org.telefon.exeption.PhoneNumberAlredyExistsExeption;
import org.telefon.exeption.PhoneNumberIsOfflineException;
import org.telefon.model.telefon.Telefon;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OperatorKomorkowy implements Operator {
    Map<String, Telefon> telefonyWSieci = new HashMap<>();

    @Override
    public void dodajTelefon(Telefon telefon) throws PhoneNumberAlredyExistsExeption {
        Optional<String> optionalFoundNumber = findPhoneNumberOnline(telefon.getInterfejsKomunikacyjny());
        if (optionalFoundNumber.isPresent()) {
            throw new PhoneNumberAlredyExistsExeption(String.format("Numer telefonu %s istnieje", optionalFoundNumber.get()));
        }
        telefonyWSieci.put(telefon.getInterfejsKomunikacyjny(), telefon);
    }

    @Override
    public void usunTelefon(Telefon telefon) {
        Optional<String> optionalFoundNumber = findPhoneNumberOnline(telefon.getInterfejsKomunikacyjny());
        if (optionalFoundNumber.isPresent()) {
            telefonyWSieci.remove(telefon.getInterfejsKomunikacyjny());
        }
    }

    public void displayAllNumbers() {
        System.out.printf("Wyswietl numer telefonu operatora (%d numerów): \n", telefonyWSieci.size());
        for (Telefon telefon : telefonyWSieci.values()) {
            System.out.println(telefon.getInterfejsKomunikacyjny());
        }
    }

    @Override
    public void dzwonNaNumer(String numerDzwonicy, String numerOdbierajacy) throws PhoneNumberIsOfflineException, PhoneCallHistoryyFullExeption {
        checkNumberIsOnline(numerDzwonicy);
        checkNumberIsOnline(numerOdbierajacy);

        telefonyWSieci.get(numerOdbierajacy).odbierz(numerDzwonicy);
    }

    private Optional<String> findPhoneNumberOnline(String searchedNumber) {
        return telefonyWSieci.keySet()
                .stream()
                .filter(numerTelefonu -> numerTelefonu.equals(searchedNumber))
                .findAny();
    }

    private void checkNumberIsOnline(String numberToCheck) throws PhoneNumberIsOfflineException {
        Optional<String> optionalFoundNumber = findPhoneNumberOnline(numberToCheck);
        if (optionalFoundNumber.isEmpty()) {
            throw new PhoneNumberIsOfflineException(String.format("Numer telefonu %s istnieje", numberToCheck));
        }
    }
}
