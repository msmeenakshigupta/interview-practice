package com.geekcircle.Thread;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-19
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class VolatileVariable extends ThreadBaseClass {

    static volatile int a = 10;

    @Override
    public void doProcess() {
        Thread t1 = new Thread(new VolatileThread(1000));
        Thread t2 = new Thread(new VolatileThread(1200));
        t1.start();
        t2.start();
    }

}

class VolatileThread implements Runnable {

    int waitTime;

    public VolatileThread(int waitTime) {
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        VolatileVariable.a = waitTime;
        System.out.println("Value Written by "+Thread.currentThread().getName()+" is "+VolatileVariable.a);
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Value Read by "+Thread.currentThread().getName()+" is "+VolatileVariable.a);
    }
}

