package com.geekcircle.Thread;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-16
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class ThreadSequence extends ThreadBaseClass {

    @Override
    public void doProcess() {
        int n = 5;
        Thread[] threads = new Thread[n];
        for(int i = 0; i < n; i++){
            threads[i] = new Thread(new CountTask(i+""));
        }
        for(Thread t : threads){
            t.start();
        }
        System.out.println("Main Thread End");
    }

}

class CountTask implements Runnable {
    private static int ctr = 0;
    private static int n = 5;
    private static int chance = ctr%n;

    private String name;

    CountTask(String name){
        this.name = name;
    }

    @Override
    public void run() {
        while (ctr < 20){
            while (true){
                if(Integer.valueOf(name) == chance){
                    break;
                }
            }
            System.out.println("Thread "+name + " ctr "+ctr++);
            chance = ctr%n;
        }
    }
}
