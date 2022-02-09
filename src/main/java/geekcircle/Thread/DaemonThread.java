package com.geekcircle.Thread;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-17
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class DaemonThread extends ThreadBaseClass implements Runnable {

    private int sleepTime;

    public DaemonThread() {
    }

    public DaemonThread(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public void doProcess() {
        Thread t = new Thread(new DaemonThread(100));
        t.setName("Normal Thread");
        t.start();

        Thread dt = new Thread(new DaemonThread(500));
        dt.setDaemon(true);
        dt.setName("Daemon Thread");
        dt.start();
    }

    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(this.sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I'm "+Thread.currentThread().getName());
    }
}