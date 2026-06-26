package org.bank;

import org.bank.model.Person;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person me = new Person("Michal", "Kaniewski", LocalDate.of(1997, 10, 9), "97100912345");
        System.out.println("My age is "+ me.getAge());
        System.out.println(me);
    }
}