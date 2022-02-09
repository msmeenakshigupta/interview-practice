package com.geekcircle.Java.New;

class ThreadDemo {

    //Visibility Problem (if we not declared as volatile)
    volatile boolean flag = true;

    public void fun1(){
        System.out.println("Fun1");
        flag = false;
    }

    public void fun2(){
        while (flag) {
            try {
                Thread.sleep(1000);
                System.out.println("Fun2");
            } catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }

}

public class VolatileDemo {
    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        Thread t1 = new Thread(()->td.fun1());
        Thread t2 = new Thread(()->td.fun2());
        t1.start();
        t2.start();
    }
}
