package org.example;

abstract class Vehicle {
    final static double MAX_SIZE_FUEAL_TANK = 40.0;
    private final String brand, model;
    private final FuelType fuelType;
    private final int year;
    protected double fuealTank;

    public Vehicle(String brand, String model, int year, FuelType fuelType) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
        this.year = year;
        this.fuealTank = MAX_SIZE_FUEAL_TANK;
    }

    public void displayInfo() {
        System.out.printf("%s - %s z roku %d na paliwo: %s ", brand, model, year, fuelType.name());
    }

    public double refuel(double liters) {
        double tankedLiters = liters + fuealTank >= MAX_SIZE_FUEAL_TANK ?
                MAX_SIZE_FUEAL_TANK - fuealTank : liters;
        fuealTank += tankedLiters;
        System.out.printf("Zatankowano %.2f z żadanych %.2f\n", tankedLiters, liters);
        return tankedLiters;
    }
}
