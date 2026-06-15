package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final double DISTANCE_TO_TRAVEL = 100;

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();

        initLists(vehicles);

        double litersToTank = 15;
        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
            driveToEmptyTank((Drivable) vehicle);

            System.out.println("\tTankowanie paliwa");
            System.out.printf("Zatankowano %.2f z żadanych %.2f\n", vehicle.refuel(litersToTank), litersToTank);
            System.out.printf("Zatankowano %.2f z żadanych %.2f\n", vehicle.refuel(litersToTank), litersToTank);
            litersToTank *= 2;
            System.out.println();
        }
    }

    static void initLists(List<Vehicle> vehicles) {
        Car carVolks = new Car("Volks Wagen", "Pasat", 2003, FuelType.DISEL, 5);
        vehicles.add(carVolks);

        Motorcycle newMotor = new Motorcycle("Junak", "M16 125", 2024, FuelType.PETROL);
        vehicles.add(newMotor);

        Car carSkoda = new Car("Skoda", "Elroq", 2026, FuelType.ELECTRIC, 3);
        vehicles.add(carSkoda);
    }

    static void driveToEmptyTank(Drivable vehicle) {
        double distanceTraveled = 1;
        while (distanceTraveled > 0) {
            distanceTraveled = vehicle.drive(DISTANCE_TO_TRAVEL);
            System.out.printf("Pojazd pokonał %.2f km\n", distanceTraveled);
        }
    }
}