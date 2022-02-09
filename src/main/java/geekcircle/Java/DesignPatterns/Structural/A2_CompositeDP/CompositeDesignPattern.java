package com.geekcircle.Java.DesignPatterns.Structural.A2_CompositeDP;

import java.util.ArrayList;
import java.util.List;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-16
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/
class Employee {

    private Integer employeeId;

    private String name;

    private List<Employee> reporters;

    public Employee(Integer employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
        this.reporters = new ArrayList<>();
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getReporters() {
        return reporters;
    }

    public void addReporter(Employee reporter) {
        reporters.add(reporter);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", reporters=" + reporters +
                '}';
    }
}


//Like a Tree structure
public class CompositeDesignPattern {

    public static void main(String[] args) {
        Employee employee = new Employee(1, "Akshay");
        employee.addReporter(new Employee(2, "Singhai"));
        employee.addReporter(new Employee(3, "Allu"));
        employee.addReporter(new Employee(4, "Shankar"));
        System.out.println(employee);
    }

}
