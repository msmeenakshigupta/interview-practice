package com.geekcircle.Thread;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-16
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

//Incomplete
public class PrintOddEvenExample extends ThreadBaseClass {

    @Override
    public void doProcess() {
        Thread t1 = new Thread(new OddEven(false));
        Thread t2 = new Thread(new OddEven(true));
        t1.setName("EVEN");
        t2.setName("ODD");
        t1.start();
        t2.start();
    }

}

class OddEven implements Runnable{

    private boolean isOdd;

    OddEven(boolean isOdd) {
        this.isOdd = isOdd;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            if(isOdd && i%2 != 0){
                System.out.println(Thread.currentThread().getName()+" "+i);
            }

            if(!isOdd && i%2 == 0){
                System.out.println(Thread.currentThread().getName()+" "+i);
            }

        }
    }
}