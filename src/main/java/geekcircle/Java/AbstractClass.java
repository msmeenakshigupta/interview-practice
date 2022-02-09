package com.geekcircle.Java;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-12
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/


class Test {
    private int a = 10;
    protected int b = 20;
    public int c = 30;

    void m1(){
        System.out.println("Test m1");
    }
}

public class AbstractClass extends Test{

    public static void main(String[] args) {
        AbstractClass a = new AbstractClass();
        a.m1();

    }

    @Override
    void m1 (){
        System.out.println("Main m1");
    }



}


