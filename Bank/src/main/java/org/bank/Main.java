package org.bank;

import org.bank.model.Account;
import org.bank.model.AccountVIP;
import org.bank.model.Count;
import org.bank.model.Person;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Count> accounts = new ArrayList<>();

    public static void main(String[] args) {
        initAccounts();

        accounts.forEach(account -> account.withdrawFromAccount(BigDecimal.valueOf(1000)));
        accounts.forEach(account -> account.depositIntoAccount(BigDecimal.valueOf(400)));

        accounts.forEach(Count::update);

        accounts.get(3).transferFunds(accounts.get(0), BigDecimal.valueOf(1500));

        System.out.println("\nInformacje o kontach przed zmianą oprocentowania:");
        accounts.forEach(System.out::println);
        Account.changeInterestRate(0.2);
        ((AccountVIP) accounts.get(2)).setIndividualInterestRate(0.08);

        System.out.println("Informacje o kontach:");
        accounts.forEach(System.out::println);
    }

    public static void initAccounts() {
        accounts.add(new Account(new Person("Jan", "Nowak", LocalDate.of(1957, 10, 6), "57100606456"),
                BigDecimal.valueOf(4600)));
        accounts.add(new Account(
                new Person("Anna", "Kowalska", LocalDate.of(1988, 3, 15), "88031512345"),
                BigDecimal.valueOf(3600)
        ));
        accounts.add(new AccountVIP(new Person("Jan", "Nowak", LocalDate.of(1957, 10, 6), "57100606456"),
                BigDecimal.valueOf(6600),
                0.2,
                BigDecimal.valueOf(1000)));
        accounts.add(new AccountVIP(
                new Person("Piotr", "Wiśniewski", LocalDate.of(1995, 7, 21), "95072167890"),
                BigDecimal.valueOf(15600),
                0.10,
                BigDecimal.valueOf(5000)
        ));
    }
}