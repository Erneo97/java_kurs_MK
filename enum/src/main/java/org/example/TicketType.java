package org.example;

import java.math.BigDecimal;

public enum TicketType {
    CHILDE("Dziecko", 0.5),
    ADLUT("Dorosły", 1),
    SENIOR("Senior", 0.8);

    private final String name;
    private final double priceMultiplier;

    TicketType(String name, double priceMultiplier) {
        this.name = name;
        this.priceMultiplier = priceMultiplier;
    }

    public static BigDecimal calculateTickerPrice(TicketType type, double basePrice) {
        return new BigDecimal( type.priceMultiplier).multiply(new BigDecimal(basePrice));
    }

    public String getName() {
        return name;
    }
}
