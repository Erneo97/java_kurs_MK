package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("Volks Wagen", "Pasat", 2003, FuelType.DISEL, 5));
        vehicles.add(new Motorcycle("Junak", "M16 125", 2024, FuelType.PETROL));
        vehicles.add(new Car("Skoda", "Elroq", 2026, FuelType.ELECTRIC, 3));

        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
            System.out.println();
        }
    }
}