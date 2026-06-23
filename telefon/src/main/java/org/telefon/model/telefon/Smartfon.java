package org.telefon.model.telefon;

import org.telefon.model.operator.Operator;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Smartfon extends Komorka {
    List<Osoba> znajomi = new ArrayList<>();

    public Smartfon(String interfejsKomunikacyjny, Color color, Operator operator) {
        super(interfejsKomunikacyjny, color, operator);
    }

    @Override
    public void wyswietlHistoriePolaczen() {
        System.out.printf("Wyswietl historie %s (%s)\n", this.getClass().getSimpleName(), this.getInterfejsKomunikacyjny());
        getPolaczeniaStream()
                .map(this::mapNumberToDisplayString)
                .forEach(numer -> System.out.printf("\t%s\n", numer));
    }

    public void addFriend(Osoba osoba) {
        if (!numberBelongsToFriend(osoba.nazwisko())) {
            znajomi.add(osoba);
        }
    }

    private String mapNumberToDisplayString(String number) {
        Optional<Osoba> foundFriend = findFriendByNumber(number);
        if (foundFriend.isPresent()) {
            Osoba osoba = foundFriend.get();
            return osoba.toString();
        }
        return number;
    }

    private Optional<Osoba> findFriendByNumber(String number) {
        return znajomi.stream()
                .filter(znajomy -> znajomy.numer().equals(number))
                .findFirst();
    }

    private boolean numberBelongsToFriend(String number) {
        return znajomi.stream()
                .anyMatch(znajomy -> znajomy.numer().equals(number));
    }
}
