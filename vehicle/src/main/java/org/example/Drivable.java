package org.example;

public interface Drivable {
    double drive(double roadTraveled);

    default double fuelCombustion(double roadTraveled, double averageCombustion, double fuealTank) {
        double fuelBurned = roadTraveled * averageCombustion / 100;
        return Math.min(fuelBurned, fuealTank);
    }

    default double calculateDistansTraveled(double liters, double averageCombustion) {
        return liters * 100 / averageCombustion;
    }
}
