package org.bank.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Person {
    private String name, surname;
    private LocalDate birthDate;
    private final String PESEL;

    public int getAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s) - %d", name, surname, getPESEL(), getAge());
    }
}
