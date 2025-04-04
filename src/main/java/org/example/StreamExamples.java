package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {

    public static void streamExample(){
        List<String> projects1 = new ArrayList<>();
        projects1.add("Project 1");
        projects1.add("Project 2");

        List<String> projects2 = new ArrayList<>();
        projects2.add("Project 1");
        projects2.add("Project 3");

        List<String> projects3 = new ArrayList<>();
        projects3.add("Project 3");
        projects3.add("Project 4");

        // Create Employee objects
        Employee emp1 = new Employee("John", "Doe", 75000.00, projects1);
        Employee emp2 = new Employee("Jane", "Smith", 85000.00, projects2);
        Employee emp3 = new Employee("Michael", "Brown", 95000.00, projects3);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);

        //Stream of
        //for each is the terminal operation after this no operation can be performed on the stream only it can be collected to collection
        employeeList.stream().
                forEach(val->{
                    System.out.println(val.toString());
                });

        //map - intermediate operation

        List<Employee> updatedEmployee = employeeList.stream().
                map(employee -> new Employee(
                        employee.getName(),
                        employee.getLastName(),
                        employee.getSalary()*1.1,
                        employee.getProjects()
                )).collect(Collectors.toList());

        System.out.println(updatedEmployee);

        //filter
        List<Employee> filterEmployee = employeeList.stream().
                filter(employee -> employee.getProjects().contains("Project 1"))
                .collect(Collectors.toList());

        System.out.println(filterEmployee);

        //find first
        Optional<Employee> firstEmployee = employeeList.stream().
                filter(employee -> employee.getSalary()>800000)
                .map(employee -> new Employee(
                        employee.getName(),
                        employee.getLastName(),
                        employee.getSalary()*1.1,
                        employee.getProjects()
                ))
                .findFirst();

        System.out.println(firstEmployee);

        //flatmap
        String stringCsv = employeeList.stream().
                map(employee -> employee.getProjects())
                .flatMap(strings -> strings.stream())
                .collect(Collectors.joining(","));

        System.out.println(stringCsv);

        //short circuit operation

        List<Employee> shortCircuitList = employeeList.stream()
                .skip(1)
                .limit(1)
                .collect(Collectors.toList());
        System.out.println(shortCircuitList);

        //converting infinite records to limited record
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

        //Sorting
        List<Employee> employees = employeeList.stream()
                .sorted((v1,v2) -> v1.getLastName().compareTo(v2.getLastName()))
                .collect(Collectors.toList());

        System.out.println(employees);

        //max salary
        employeeList.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);

        //reduce
        //calculate total distributed salary
        employeeList.stream()
                .map(employee -> employee.getSalary())
                .reduce(Double::sum)
                .ifPresent(System.out::println);
    }
}
