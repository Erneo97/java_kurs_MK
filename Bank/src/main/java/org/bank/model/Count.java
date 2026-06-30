package org.bank.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@AllArgsConstructor
public abstract class Count {
    protected final Person owner;
    protected BigDecimal balance;

    /**
     * operacja wpłaty podanej kwoty, zwracająca true w przypadku sukcesu operacji, false w przeciwnym przypadku,
     */
    public boolean depositIntoAccount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            return false;
        }
        balance = balance.add(amount);
        return true;
    }

    /**
     * operacja wypłaty podanej kwoty, zwracająca true w przypadku sukcesu operacji, false w przeciwnym przypadku (np. kiedy na rachunku jest za mało środków),
     */
    public boolean withdrawFromAccount(BigDecimal amount) {
        if (balance.compareTo(amount) <= 0) {
            return false;
        }
        balance = balance.subtract(amount);
        return true;
    }

    /**
     * operacja przelewu podanej kwoty z rachunku na podany (jako argument metody) rachunek, zwracająca true w przypadku sukcesu operacji, false w przeciwnym przypadku,
     */
    public boolean transferFunds(Count destination, BigDecimal amount) {
        if (destination == null || !this.withdrawFromAccount(amount)) {
            return false;
        }

        if (!destination.depositIntoAccount(amount)) {
            this.depositIntoAccount(amount);
            return false;
        }
        return true;
    }

    /**
     * wyświetlająca komunikat: "Rachunek podstawowy".
     */
    public void update() {
        System.out.println("Rachunek podstawowy.");
    }
}