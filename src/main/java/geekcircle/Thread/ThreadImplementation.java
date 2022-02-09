package com.geekcircle.Thread;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-17
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class ThreadImplementation extends ThreadBaseClass {

    @Override
    public void doProcess() {
        NewThread1 byExtending = new NewThread1();
        Thread byImplementing = new Thread(new NewThread2());
        byExtending.start();
        byImplementing.start();
    }
}

class NewThread1 extends Thread {

    @Override
    public void run() {
        System.out.println("Thread "+ Thread.currentThread().getName());
    }

}

//This is best approach
class NewThread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread "+ Thread.currentThread().getName());
    }

}


