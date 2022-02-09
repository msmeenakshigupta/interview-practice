package com.geekcircle.Java;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-13
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

interface Interface1 {

    void m1();

}

interface Interface2 {

    void m1();

}

public class AbstractClassExample implements Interface1, Interface2 {
    public static void main(String[] args) {

    }

    @Override
    public void m1() {
        System.out.println("Hi");
    }
}
