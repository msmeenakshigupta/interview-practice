package com.geekcircle.Java;

class DemoOneTwoThree {

    Integer i = 0;

    public void one(){
        while (true){
            synchronized (this){
                if(i % 3 == 0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" "+(i+1));
                    i++;
                    notifyAll();
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

    public void two(){
        while (true){
            synchronized (this){
                if(i % 3 == 1){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" "+(i+1));
                    i++;
                    notifyAll();
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

    public void three(){
        while (true){
            synchronized (this){
                if(i % 3 == 2){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" "+(i+1));
                    i++;
                    notifyAll();
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

public class OneTwoThreeThread {
    public static void main(String[] args) {
        DemoOneTwoThree d = new DemoOneTwoThree();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                d.one();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                d.two();
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                d.three();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
