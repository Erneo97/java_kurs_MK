package org.example;

import java.math.BigDecimal;

public enum fuelType {
    PETROL(5.68),
    DISEL(5.30),
    ELECTRIC(2.5);

    double price;

    private fuelType(double price) {
        this.price = price;
    }

    public static BigDecimal calculatePrice(fuelType type, double volume) {
        return BigDecimal.valueOf(type.price).multiply(BigDecimal.valueOf(volume));
    }


}
