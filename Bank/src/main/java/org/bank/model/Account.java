package org.bank.model;

import java.math.BigDecimal;

public class Account extends Count {
    protected static double interestRate = 0.05;

    public Account(Person owner, BigDecimal balance) {
        super(owner, balance);
    }

    public static void changeInterestRate(double interestRate) {
        Account.interestRate = interestRate;
    }

    @Override
    public void update() {
        balance = balance.add(balance.multiply(BigDecimal.valueOf(interestRate)));
    }

    @Override
    public String toString() {
        return String.format("%s %s pln", owner, balance);
    }
}
