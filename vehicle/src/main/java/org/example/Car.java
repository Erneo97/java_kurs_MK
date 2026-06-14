package org.example;

public class Car extends Vehicle implements Drivable {
    final static double AVERAGE_VEHICLE_COMBUSTION = 7.4;

    private final int doors;

    public Car(String brand, String model, int year, FuelType fuelType, int doors) {
        super(brand, model, year, fuelType);
        this.doors = doors;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.print(" wersja " + doors + " drzwiowa");
    }

    @Override
    public double drive(double roadTraveled) {
        double burnedFuel = fuelCombustion(roadTraveled, AVERAGE_VEHICLE_COMBUSTION, fuealTank);
        fuealTank -= burnedFuel;
        double distanceTraveled = calculateDistansTraveled(burnedFuel, AVERAGE_VEHICLE_COMBUSTION);
        System.out.printf("Samochód przejechał %.2f km - zostało paliwa: %.2f", distanceTraveled, fuealTank);
        return distanceTraveled;
    }
}
