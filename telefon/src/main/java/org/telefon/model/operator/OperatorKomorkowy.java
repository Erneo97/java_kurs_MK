package org.telefon.model.operator;

import org.telefon.exeption.PhoneNumberAlredyExistsExeption;
import org.telefon.exeption.PhoneNumberIsOfflineExeption;
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

    private Optional<String> findPhoneNumberOnline(String searchedNumber) {
        return telefonyWSieci.keySet()
                .stream()
                .filter(numerTelefonu -> numerTelefonu.equals(searchedNumber))
                .findAny();
    }

    @Override
    public void usunTelefon(Telefon telefon) {
        Optional<String> optionalFoundNumber = findPhoneNumberOnline(telefon.getInterfejsKomunikacyjny());
        if (optionalFoundNumber.isPresent()) {
            telefonyWSieci.remove(telefon.getInterfejsKomunikacyjny());
        }
    }

    @Override
    public void dzwonNaNumer(String numer) throws PhoneNumberIsOfflineExeption {

    }
}
