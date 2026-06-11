package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        cars.add(new ElectricCar());
        cars.add(new FuelCar());

        for (Car car : cars) {
            car.starEngine();
        }
    }
}