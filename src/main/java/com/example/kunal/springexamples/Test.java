package com.example.kunal.springexamples;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

     System.out.println("Try programiz.pro");
    List<Employee> list = new ArrayList<>();
        list.add(new Employee("kunal", "HR", 100));
        list.add(new Employee("Anmol", "HR", 150));
        list.add(new Employee("Rishabh", "IT", 200));
        list.add(new Employee("Karan", "IT", 250));
        System.out.println(list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.minBy(Comparator.comparingInt(Employee::getSalary)))));
}

@ToString
static class Employee{
    private String name;
    private String department;
    private int salary;

    public String getDepartment(){
        return department;
    }

    public int getSalary(){
        return salary;
    }

    public Employee(String name, String department, int salary){
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}
}
