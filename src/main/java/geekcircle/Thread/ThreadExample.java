package com.geekcircle.Thread;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-16
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class ThreadExample extends ThreadBaseClass {

    @Override
    public void doProcess(){
        Thread t = new Thread(new TaskToDo());
        t.start();
    }

}

class TaskToDo implements Runnable {

    @Override
    public void run() {
        System.out.println("Task Started by "+Thread.currentThread().getName());
        for(int i = 0; i < 10; i++){
            System.out.println("Task by " + Thread.currentThread().getName() + " i: "+ i);
        }
        System.out.println("Task Ended by "+Thread.currentThread().getName());
    }
}
