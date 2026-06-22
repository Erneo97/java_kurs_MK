package org.telefon;

import org.telefon.exeption.NumberFormatExeption;
import org.telefon.exeption.PhoneCallHistoryyFullExeption;
import org.telefon.exeption.PhoneNumberIsOfflineException;
import org.telefon.model.operator.OperatorKomorkowy;
import org.telefon.model.telefon.Komorka;
import org.telefon.model.telefon.Osoba;
import org.telefon.model.telefon.Smartfon;
import org.telefon.model.telefon.Telefon;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static final List<Telefon> telefons = new ArrayList<>();
    private static List<String> phoneNumbers = new ArrayList<>();
    private static final OperatorKomorkowy operatorKomorkowy = new OperatorKomorkowy();
    private static final int coutOfTestNumbers = 10;

    private static void createPhonesNumber() {
        Set<String> phoneNumbersRand = new HashSet<>();
        while (phoneNumbersRand.size() < coutOfTestNumbers) {
            String number = String.format("%03d-%03d-%03d",
                    randNumber0_999(),
                    randNumber0_999(),
                    randNumber0_999());
            phoneNumbersRand.add(number);
        }
        phoneNumbers = phoneNumbersRand.stream().toList();
    }

    private static int randNumber0_999() {
        return ThreadLocalRandom.current().nextInt(0, 999);
    }

    private static void initTelefons() {
        int indexOfPhone = 0;
        for (; indexOfPhone < coutOfTestNumbers - 2; indexOfPhone++) {
            telefons.add(new Komorka(phoneNumbers.get(indexOfPhone), Color.BLACK, operatorKomorkowy));
        }
        Smartfon smartfon1 = new Smartfon(phoneNumbers.get(indexOfPhone++), Color.GRAY, operatorKomorkowy);
        Smartfon smartfon2 = new Smartfon(phoneNumbers.get(indexOfPhone), Color.YELLOW, operatorKomorkowy);

        telefons.addAll(Arrays.asList(smartfon1, smartfon2));

        indexOfPhone = 0;
        smartfon1.addFriend(new Osoba("Jan", "Kowalski", phoneNumbers.get(indexOfPhone++)));
        smartfon1.addFriend(new Osoba("Jan", "Mazowiecki", phoneNumbers.get(indexOfPhone++)));
        smartfon1.addFriend(new Osoba("Jan", "Woźniak", phoneNumbers.get(indexOfPhone++)));
        smartfon1.addFriend(new Osoba("Jan", "Krawczyk", phoneNumbers.get(indexOfPhone++)));
        smartfon1.addFriend(new Osoba("Jan", "Drzymała", phoneNumbers.get(indexOfPhone++)));

        smartfon2.addFriend(new Osoba("Anna", "Kowalska", phoneNumbers.get(indexOfPhone++)));
        smartfon2.addFriend(new Osoba("Anna", "Mazowiecka", phoneNumbers.get(indexOfPhone++)));
        smartfon2.addFriend(new Osoba("Anna", "Woźniak", phoneNumbers.get(indexOfPhone++)));
        smartfon2.addFriend(new Osoba("Anna", "Krawczyk", phoneNumbers.get(indexOfPhone++)));
        smartfon2.addFriend(new Osoba("Anna", "Drzymała", phoneNumbers.get(indexOfPhone)));
    }

    private static void dzwonDoWszystkichOdWszystkich() {
        telefons.forEach(telefon -> {
            phoneNumbers.forEach(numerTelefonu -> {
                try {
                    telefon.zadzwon(numerTelefonu);
                } catch (PhoneNumberIsOfflineException | PhoneCallHistoryyFullExeption | NumberFormatExeption e) {
                    System.err.printf("%s dla numeru %s\n%n", e.getMessage(), telefon.getInterfejsKomunikacyjny());
                }
            });
        });
    }

    public static void main(String[] args) {
        createPhonesNumber();
        initTelefons();

        operatorKomorkowy.displayAllNumbers();

        dzwonDoWszystkichOdWszystkich();
        telefons.forEach(Telefon::wyswietlHistoriePolaczen);
    }
}