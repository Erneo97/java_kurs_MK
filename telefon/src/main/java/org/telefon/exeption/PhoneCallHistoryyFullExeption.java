package org.telefon.exeption;

import java.util.concurrent.Executors;

public class PhoneCallHistoryyFullExeption extends RuntimeException {
    public PhoneCallHistoryyFullExeption(String message) {
        super(message);
    }
}
