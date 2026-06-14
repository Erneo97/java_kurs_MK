package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        List<Drivable> vehiclesDrivable = new ArrayList<>();

        initLists(vehicles, vehiclesDrivable);

        double litersToTank = 15;
        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
            driveToEmptyTank((Drivable) vehicle);

            System.out.println("\tTankowanie paliwa");
            vehicle.refuel(litersToTank);
            vehicle.refuel(litersToTank);
            litersToTank *= 2;
            System.out.println();
        }

    }

    static void initLists(List<Vehicle> vehicles, List<Drivable> vehiclesDrivable) {
        Car carVolks = new Car("Volks Wagen", "Pasat", 2003, FuelType.DISEL, 5);
        vehicles.add(carVolks);
        vehiclesDrivable.add(carVolks);

        Motorcycle newMotor = new Motorcycle("Junak", "M16 125", 2024, FuelType.PETROL);
        vehicles.add(newMotor);
        vehiclesDrivable.add(newMotor);

        Car carSkoda = new Car("Skoda", "Elroq", 2026, FuelType.ELECTRIC, 3);
        vehicles.add(carSkoda);
    }

    private static final double DISTANCE_TO_TRAVEL = 100;

    static void driveToEmptyTank(Drivable vehicle) {
        double distanceTraveled = 1;
        while (distanceTraveled > 0) {
            distanceTraveled = vehicle.drive(DISTANCE_TO_TRAVEL);
            System.out.printf("Pojaz pokonał %.2f km\n", distanceTraveled);
        }
    }
}