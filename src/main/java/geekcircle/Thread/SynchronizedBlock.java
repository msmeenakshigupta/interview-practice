package com.geekcircle.Thread;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-19
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class SynchronizedBlock extends ThreadBaseClass {
    static Integer test = 1;
    static volatile int j;

    @Override
    public void doProcess() {
        Thread t1 = new Thread(new SynchronizedThread1());
        Thread t2 = new Thread(new SynchronizedThread2());
        t1.start();
        t2.start();
    }

    static void method(int i){
        j = i;
        System.out.println(j);
        synchronized (SynchronizedBlock.test){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread "+i+" Start");
            System.out.println("Thread "+i+" End");
        }
    }


}

class SynchronizedThread1 implements Runnable {

    @Override
    public void run() {
        SynchronizedBlock.method(1);
    }
}

class SynchronizedThread2 implements Runnable{

    @Override
    public void run() {
        SynchronizedBlock.method(2);
    }

}