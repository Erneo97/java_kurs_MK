package org.telefon;

import org.telefon.model.telefon.Telefon;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static List<Telefon> telefons = new ArrayList<>();
    private static Set<String> phoneNumbers = new HashSet<>();

    private static void createPhonesNumber(int coutOfNumbers) {
        while (phoneNumbers.size() < coutOfNumbers) {
            String number = String.format("%03d-%03d-%03d",
                    randNumber0_999(),
                    randNumber0_999(),
                    randNumber0_999());
            phoneNumbers.add(number);
        }
    }

    private static int randNumber0_999() {
        return ThreadLocalRandom.current().nextInt(0, 999);
    }

    public static void main(String[] args) {
        int coutOfTestNumbers = 5;
        createPhonesNumber(coutOfTestNumbers);


    }
}