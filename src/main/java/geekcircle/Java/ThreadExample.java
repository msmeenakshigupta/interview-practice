package com.geekcircle.Java;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-14
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.concurrent.Callable;

public class ThreadExample {
    public static void main(String[] args) {

        Thread t = new Thread(){
            @Override
            public void run() {
                System.out.println("Runnable : "+Thread.currentThread().getName());
            }
        };
        t.start();
    }
}
