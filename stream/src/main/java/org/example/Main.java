package org.example;

import org.example.model.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        testPoint();
        testIntegerArray();
        testSFunctionString();
    }

    private static void testSFunctionString() {
        Function<String, String> trimWhiteCase = String::trim;
        Function<String, String> toUpperCase = String::toUpperCase;
        Function<String, String> allInOne = trimWhiteCase.andThen(toUpperCase);
        Function<String, String> allInOneV2 = trimWhiteCase.compose(toUpperCase);

        String testString = " hello world ";
        System.out.printf("trimWhiteCase: '%s'\n", trimWhiteCase.apply(testString));
        System.out.printf("toUpperCase: '%s'\n", toUpperCase.apply(testString));
        System.out.printf("allInOne: '%s'\n", allInOne.apply(testString));
        System.out.printf("allInOneV2: '%s'\n", allInOneV2.apply(testString));
    }

    private static void testIntegerArray() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 10, 15, 20);
        System.out.println("Lista parzystych:");
        getFiltradedIntegerList(numbers, num -> num % 2 == 0).forEach(System.out::println);
    }

    private static List<Integer> getFiltradedIntegerList(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .filter(predicate)
                .toList();
    }


    private static void testPoint() {
        List<org.example.model.Point> points = new ArrayList<>(List.of(
                new org.example.model.Point(1, 2),
                new org.example.model.Point(3, 4),
                new org.example.model.Point(5, 6),
                new org.example.model.Point(7, 8),
                new org.example.model.Point(9, 10),
                new org.example.model.Point(10, 11)));

        var xList = points.stream()
                .filter(point -> point.x() > 3 && point.x() < 9)
                .map(Point::x)
                .toList();

//        xList.add(23.0);

        for (double x : xList) {
            System.out.println(x);
        }
    }
}

