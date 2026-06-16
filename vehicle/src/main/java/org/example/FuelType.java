package org.example;

import java.math.BigDecimal;

public enum FuelType {
    PETROL(5.68),
    DISEL(5.30),
    ELECTRIC(2.5);

    final double price; // BigDecimal od razu

    private FuelType(double price) {
        this.price = price;
    }

    public static BigDecimal calculatePrice(FuelType type, double volume) {
        return BigDecimal.valueOf(type.price).multiply(BigDecimal.valueOf(volume));
    }
}
