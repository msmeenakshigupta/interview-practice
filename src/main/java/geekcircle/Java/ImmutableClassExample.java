package com.geekcircle.Java;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-07
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

final class Student {

    final long sId;

    final Map<String, Integer> courseMarks;

    public Student(long sId, Map<String, Integer> courseMarks) {
        this.sId = sId;

        //Shallow Copy
        //this.courseMarks = courseMarks;

        //Deep Copy
        Map<String, Integer> map = new LinkedHashMap<>();
        for(String s : courseMarks.keySet()){
            map.put(s, courseMarks.get(s));
        }
        this.courseMarks = map;
    }

    public long getsId() {
        return sId;
    }

    public Map<String, Integer> getCourseMarks() {
        return courseMarks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", courseMarks=" + courseMarks +
                '}';
    }
}

public class ImmutableClassExample {
    public static void main(String[] args) {
        HashMap<String, Integer> courseMarks = new HashMap<>();
        courseMarks.put("Hindi", 10);
        courseMarks.put("English", 15);
        courseMarks.put("Maths", 11);
        courseMarks.put("Science", 12);
        Student e =  new Student(1, courseMarks);
        courseMarks.put("Hindi", 13); //in Deep copy change will not reflect but in shallow copy this will visible
        System.out.println(e);
    }
}
