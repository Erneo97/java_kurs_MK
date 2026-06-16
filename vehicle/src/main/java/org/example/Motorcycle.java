package org.example;

public class Motorcycle extends Vehicle implements Drivable {
    final static double AVERAGE_VEHICLE_COMBUSTION = 3.1;

    public Motorcycle(String brand, String model, int year, FuelType fuelType) {
        super(brand, model, year, fuelType);
    }

    public double drive(double roadTraveled) {
        double burnedFuel = fuelCombustion(roadTraveled, AVERAGE_VEHICLE_COMBUSTION, fuelTank);
        fuelTank -= burnedFuel;
        double distanceTraveled = calculateDistansTraveled(burnedFuel, AVERAGE_VEHICLE_COMBUSTION);
        System.out.printf("Motor przejechał %.2f km - zostało paliwa: %.2f", distanceTraveled, fuelTank);
        return distanceTraveled;
    }
}
