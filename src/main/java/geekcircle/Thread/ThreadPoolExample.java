package com.geekcircle.Thread;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-14
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample extends ThreadBaseClass {

    //This is also Called Executor Design Pattern
    @Override
    public void doProcess(){
        Runnable r1 = new Task("Task 1");
        Runnable r2 = new Task("Task 2");
        Runnable r3 = new Task("Task 3");
        Runnable r4 = new Task("Task 4");
        Runnable r5 = new Task("Task 5");
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);
        pool.execute(r5);
    }
}


class Task implements Runnable {

    private String name;

    Task(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Thread "+name+" Started");
        for(int i = 0; i < 10; i++){
            try {
                Thread.sleep(500);
                System.out.println("Hi I'm " + name + " Executing Iteration "+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread "+name+" Ended");
    }
}