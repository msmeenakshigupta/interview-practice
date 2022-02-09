package com.geekcircle.Java.DesignPatterns.Creational.A5_BuilderDP;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-19
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.ArrayList;
import java.util.List;

class Employee {

    private Integer id;

    private String name;

    //Composite Pattern
    private List<Employee> reporters;

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
        reporters = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getReporters() {
        return reporters;
    }

    public Employee setReporter(Employee employee) {
        this.reporters.add(employee);
        return this;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reporters=" + reporters +
                '}';
    }
}

public class BuilderDesignPattern {

    public static void main(String[] args) {
        Employee developer1 = new Employee(1, "Akshay");
        Employee developer2 = new Employee(2, "Akash");
        Employee manager = new Employee(3, "Rakesh").setReporter(developer1).setReporter(developer2);
        System.out.println(manager);
    }
}
