package org.example;

import java.util.List;

public class Employee {

    private String name;

    private String lastName;

    private double salary;

    private List<String> projects;

    public Employee(String name, String lastName, double salary, List<String> projects) {
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", projects=" + projects +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }
}
