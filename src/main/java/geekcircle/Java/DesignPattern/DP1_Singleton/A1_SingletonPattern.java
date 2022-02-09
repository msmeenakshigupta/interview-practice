package com.geekcircle.Java.DesignPattern.DP1_Singleton;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-07
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/


/*
    -> Various ways to create singleton object
        * Eager Initialization
        * Static Block Initialization
        * Lazy Initialization
        * Thread Safe DP1_Singleton (double check locking)
        * using private static Inner class

 */


class SingleTonClass {

    private static SingleTonClass object;

    private SingleTonClass() {
        //Eager In Initialization
        System.out.println("Object Created");
    }

    //Static Class Initialization / Static inner class loads when it calls;
    private static class SingleTonInnerClass {
        private static SingleTonClass object = new SingleTonClass();
    }

    //Static Initialization
    static {

    }

    static synchronized SingleTonClass getInstance() {
        if(object == null){
            //Lazy Initialization
            object = new SingleTonClass();
        }
        return object;
    }

}

// java.lang.Runtime is example of DP1_Singleton design pattern
public class A1_SingletonPattern {
    public static void main(String[] args) {
        SingleTonClass ob1 = SingleTonClass.getInstance();
    }
}
