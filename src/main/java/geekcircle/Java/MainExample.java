package com.geekcircle.Java;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-12
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

class Parent {

    public static void foo1(){
        System.out.println("Parent Foo1");
    }

    public void foo2(){
        System.out.println("Parent Foo2");
    }
}

class Child extends Parent {

    //Method Hiding
    public static void foo1(){
        System.out.println("Child Foo1");
    }

    //Method Overriding
    public void foo2(){
        System.out.println("Child Foo2");
    }
}

public class MainExample {

    public static void main(String[] args) {

        Parent p = new Parent();
        Parent c = new Child();
        p.foo1();
        c.foo1();

        p.foo2();
        c.foo2();

    }
}
