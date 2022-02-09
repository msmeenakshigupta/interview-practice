package com.geekcircle.Java;

class Demo {

    Integer i = 0;

    public void printEven(){
        while (i <= 10){
            synchronized (this){
                if(i % 2 == 0){
                    System.out.println(Thread.currentThread().getName()+" "+i);
                    i++;
                    notify();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void printOdd(){
        while (i <= 10){
            synchronized (this){
                if(i % 2 != 0){
                    System.out.println(Thread.currentThread().getName()+" "+i);
                    i++;
                    notify();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

public class PrintAlternative {
    public static void main(String[] args) {
        Demo d = new Demo();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                d.printEven();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                d.printOdd();
            }
        });
        thread1.start();
        thread2.start();
    }
}
