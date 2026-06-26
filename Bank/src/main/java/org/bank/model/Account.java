package org.bank.model;

import java.math.BigDecimal;

public abstract class Account {
    private final Person owner;
    private BigDecimal balance;

    public Account(Person owner, BigDecimal balance) {
        this.owner = owner;
        this.balance = balance;
    }

    /**
     * operacja wpłaty podanej kwoty, zwracająca true w przypadku sukcesu operacji, false w przeciwnym przypadku,
     */
    public boolean depositIntoAccount(BigDecimal amount) {
        if( amount.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }
        balance = balance.add(amount);
        return true;
    }

    /**
     * operacja wypłaty podanej kwoty, zwracająca true w przypadku sukcesu operacji, false w przeciwnym przypadku (np. kiedy na rachunku jest za mało środków),
     */
    public boolean withdrawFromAccount(BigDecimal amount) {
        if( balance.compareTo(amount) <= 0) {
            return false;
        }
        balance = balance.subtract(amount);
        return true;
    }

    /**
     * operacja przelewu podanej kwoty z rachunku na podany (jako argument metody) rachunek, zwracająca true w przypadku sukcesu operacji, false w przeciwnym przypadku,
     */
    public boolean transferFunds(Account destination, BigDecimal amount) {
        if( destination == null ) {
            return false;
        }
        return withdrawFromAccount(amount) && destination.depositIntoAccount(amount);
    }

    public void update() {
        System.out.println("Rachunek podstawowy.");
    }

    @Override
    public String toString() {
        return String.format("%s %s", owner, balance);
    }
}
