package com.geekcircle.Java;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-12
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class StaticBlockExample {

    static int a;

    static {
        a = 10;
        System.out.println("Static Blocked Called");
    }

    public StaticBlockExample() {
        System.out.println("Constructor Called");
    };
}
