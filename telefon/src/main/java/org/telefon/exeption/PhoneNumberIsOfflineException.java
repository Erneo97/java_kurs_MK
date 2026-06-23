package org.telefon.exeption;

public class PhoneNumberIsOfflineException extends RuntimeException {
    public PhoneNumberIsOfflineException(String format) {
        super(format);
    }
}
