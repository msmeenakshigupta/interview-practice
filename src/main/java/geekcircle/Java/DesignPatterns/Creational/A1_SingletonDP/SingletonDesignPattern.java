package com.geekcircle.Java.DesignPatterns.Creational.A1_SingletonDP;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-16
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

class Singleton {

    private static Singleton singleton;

    private Singleton(){
        System.out.println("initialized");
    }

    public static Singleton getInstance(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}

public class SingletonDesignPattern {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}
