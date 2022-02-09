package com.geekcircle.Thread;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-16
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class PrintSequenceByThread extends ThreadBaseClass {

    static Integer n = 0;

    @Override
    public void doProcess() {
        Thread t1 = new Thread(new PrintSequence(0));
        t1.setName("#1");
        Thread t2 = new Thread(new PrintSequence(1));
        t2.setName("#2");
        Thread t3 = new Thread(new PrintSequence(2));
        t3.setName("#3");
        t1.start();
        t2.start();
        t3.start();
    }

}

class PrintSequence implements Runnable {

    int n;

    public PrintSequence(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        while (PrintSequenceByThread.n < 10){
            while (PrintSequenceByThread.n%3 != n && PrintSequenceByThread.n < 10);
            System.out.println("Thread "+Thread.currentThread().getName() + " "+ PrintSequenceByThread.n);
            PrintSequenceByThread.n++;
        }
    }

}
