package org.telefon.exeption;

import java.util.concurrent.ExecutionException;

public class NumberFormatExeption extends ExecutionException {
    public NumberFormatExeption(String message) {
        super(message);
    }
}
