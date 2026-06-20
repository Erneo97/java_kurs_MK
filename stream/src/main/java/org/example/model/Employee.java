package org.example.model;

public class Employee {
    String name;
    String department;
    int age;

    public Employee(String name, int age, String department) {
        this.name = name;
        this.department = department;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                '}';
    }
}
