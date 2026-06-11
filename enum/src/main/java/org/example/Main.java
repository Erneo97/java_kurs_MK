package org.example;

public class Main {
    public static void main(String[] args) {
        double base = 100;

        System.out.println("Bazowa cena: " + base);
        System.out.println("\tCena dla danych biletów");
        for (TicketType type : TicketType.values()) {
            System.out.printf("%7s cena: %8.2f%n", type.getName(), TicketType.calculateTickerPrice(type, base));
        }
    }
}