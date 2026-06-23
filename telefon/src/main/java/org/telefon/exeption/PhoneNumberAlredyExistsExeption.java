package org.telefon.exeption;

public class PhoneNumberAlredyExistsExeption extends RuntimeException {
    public PhoneNumberAlredyExistsExeption(String message) {
        super(message);
    }
}
