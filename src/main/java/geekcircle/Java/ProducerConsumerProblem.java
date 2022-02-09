package com.geekcircle.Java;

import java.util.LinkedList;
import java.util.Queue;

class Resource {
    Queue<Integer> queue = new LinkedList<>();

    public void produce(){
        try {
            for(int i = 0; i < 10; i++){
                Thread.sleep(1000);
                synchronized (this){
                    int j = 10+i;
                    queue.add(j);
                    System.out.println(j+" Produced");
                    notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void consume(){
        while (true){
            try {
                synchronized (this){
                    if(!queue.isEmpty()){
                        System.out.println(queue.poll() + " Consumed");
                    } else {
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

public class ProducerConsumerProblem {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                resource.produce();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                resource.consume();
            }
        });
        thread1.start();
        thread2.start();
    }
}
