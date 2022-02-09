package com.geekcircle.Java;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-12
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee implements Comparable <Employee> {

    private Long employeeId;

    private String rollNo;

    private String name;

    public Employee(Long employeeId, String rollNo, String name) {
        this.employeeId = employeeId;
        this.rollNo = rollNo;
        this.name = name;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Employee o) {
        System.out.println("Comparator Called");
        return (int)(this.employeeId - o.employeeId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", rollNo='" + rollNo + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

public class SortCustomObject {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1L, "ABC43", "Ramesh"));
        employeeList.add(new Employee(3L, "ABC42", "Suresh"));
        employeeList.add(new Employee(2L, "ABC44", "Rakesh"));
        employeeList.add(new Employee(15L, "ABC33", "Ekta"));
        employeeList.add(new Employee(33L, "ABC1", "Ashok"));
        employeeList.add(new Employee(35L, "ABC79", "Adarsh"));
        employeeList.add(new Employee(24L, "ABC66", "Dev"));

        Comparator<Employee> sortByEmployeeId = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int)(o1.getEmployeeId() - o2.getEmployeeId());
            }
        };

        Comparator<Employee> sortByRollNo = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int)o1.getRollNo().compareTo(o2.getRollNo());
            }
        };

        Comparator<Employee> sortByName = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int)(o1.getName().compareTo(o2.getName()));
            }
        };

        Collections.sort(employeeList, sortByName);
        System.out.println(employeeList);
    }

}