package org.bank.model;

import java.math.BigDecimal;

public class AccountVIP extends Account {
    protected final double individualInterestRate;
    protected final BigDecimal debetLimit;

    public AccountVIP(Person owner, BigDecimal balance, double individualInterestRate, BigDecimal debetLimit) {
        super(owner, balance);
        this.individualInterestRate = individualInterestRate;
        this.debetLimit = debetLimit;
    }

    @Override
    public boolean withdrawFromAccount(BigDecimal amount) {
        if (balance.compareTo(amount.add(debetLimit)) <= 0) {
            return false;
        }
        balance = balance.subtract(amount);
        return true;
    }

    @Override
    public void update() {
        balance = balance.add(balance.multiply(BigDecimal.valueOf(individualInterestRate)));
    }

    @Override
    public String toString() {
        return String.format("%s %s (%.2f)", owner, balance, individualInterestRate);
    }
}
