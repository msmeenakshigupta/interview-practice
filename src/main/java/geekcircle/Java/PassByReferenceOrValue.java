package com.geekcircle.Java;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-12
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class SampleClass implements Serializable {

    Integer item;

    SampleClass(Integer item){
        this.item = item;
    }

    @Override
    public String toString() {
        return "SampleClass{" +
                "item=" + item +
                '}';
    }

}

public class PassByReferenceOrValue {
    public static void main(String[] args) {
        SampleClass sampleClass = new SampleClass(10);
        System.out.println("Before "+sampleClass);
        test(sampleClass);
        System.out.println("After "+sampleClass);
        List<Integer> al = new ArrayList<>();
        System.out.println("Before "+al);
        test1(al);
        System.out.println("After "+al);



    }

    private static void test1(List<Integer> al) {
        al.add(2020);
    }

    private static void test(SampleClass sampleClass){
        sampleClass.item = 20;
    }

}
