package com.geekcircle.Java.Collections;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-19
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.*;

class Employee {
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class QueueExample {

    public static void main(String[] args) {

        /*Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue.poll());
        System.out.println(queue);*/


        Map<Integer, Employee> map = new LinkedHashMap<>();
        for(int i = 0; i < 5; i++ ){
            map.put(10+i, new Employee(100-i, (char)((int)'A'+(int)(Math.random()*10)) + "B"));
        }

        Comparator<Map.Entry<Integer, Employee>> comparator = new Comparator<Map.Entry<Integer, Employee>>() {

            @Override
            public int compare(Map.Entry<Integer, Employee> o1, Map.Entry<Integer, Employee> o2) {
                return o2.getValue().name.compareTo(o1.getValue().name);
            }
        };

        //Sort Map
        Set<Map.Entry<Integer,Employee>> set  = new TreeSet<>(comparator);
        set.addAll(map.entrySet());

        Map<Integer, Employee> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<Integer, Employee> e : set){
            sortedMap.put(e.getKey(), e.getValue());
        }

        System.out.println(sortedMap);
    }
}
