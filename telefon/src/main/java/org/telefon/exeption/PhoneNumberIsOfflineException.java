package org.telefon.exeption;

public class PhoneNumberIsOfflineException extends Exception {
    public PhoneNumberIsOfflineException(String format) {
        super(format);
    }
}
