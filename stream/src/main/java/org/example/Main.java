package org.example;

import org.example.model.Employee;
import org.example.model.Point;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        testPoint();
        testIntegerArray();
        testSFunctionString();

        testExe8Employee();

        testExercise9String();
    }

    private static void testExercise9String() {
        List<String> sentences = Arrays.asList("hello java world", "java streams", "world of code hello");

        System.out.println(exercise9(sentences));
    }

    private static String exercise9(List<String> sentences) {
        return sentences.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
    }

    private static void testExe8Employee() {
        System.out.println("\n\tZadanie 8 - Klasa employee");
        List<Employee> employees = createEmployees();

        Predicate<Employee> filtrAge = e -> e.getAge() > 25;

        List<Employee> filtratedEmployeesByAge = getFilatratedListByPredicate(employees, filtrAge);
        System.out.println("Pracownicy powyżej 25: " + filtratedEmployeesByAge);

        System.out.println("Posortowane imiona pracowników: " + getSortedAscNamesEmployees(filtratedEmployeesByAge));
        System.out.println("Posortowane imiona pracowników: " + getSortedDscNamesEmployees(filtratedEmployeesByAge));

        System.out.println("Posortowane imiona pracowników: " + getNamesAndFiltrEmployee(employees, filtrAge));

        showGroupedEmployeesByDepartament(groupEmployeeByDepartment(employees));
    }

    private static Map<String, List<Employee>> groupEmployeeByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    private static void showGroupedEmployeesByDepartament(Map<String, List<Employee>> groupedEmployees) {
        System.out.println("Pogrupowani pracownicy do departamentu:");
        for (String departament : groupedEmployees.keySet() ) {
            System.out.printf("%12s: %s\n",departament, groupedEmployees.get(departament));
        }
    }

    private static List<String> getNamesAndFiltrEmployee(List<Employee> employees, Predicate<Employee> filter) {
        return employees.stream()
                .filter(filter)
                .map(Employee::getName)
                .sorted()
                .toList();
    }

    private static List<String> getSortedAscNamesEmployees(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .sorted()
                .toList();
    }

    private static List<String> getSortedDscNamesEmployees(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    private static List<Employee> getFilatratedListByPredicate(List<Employee> employees, Predicate<Employee> predicate) {
        return employees.stream()
                .filter(predicate)
                .toList();
    }

    private static List<Employee> createEmployees() {
        return List.of(
                new Employee("Anna", 25, "IT"),
                new Employee("Jan", 30, "HR"),
                new Employee("Kasia", 28, "Finance"),
                new Employee("Marek", 35, "IT"),
                new Employee("Ola", 22, "Marketing"),
                new Employee("Piotr", 40, "Sales"),
                new Employee("Ewa", 27, "HR"),
                new Employee("Tomek", 32, "Finance"),
                new Employee("Natalia", 22, "IT"),
                new Employee("Adam", 45, "Management")
        );
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

