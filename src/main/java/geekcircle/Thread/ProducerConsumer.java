package com.geekcircle.Thread;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-16
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer extends ThreadBaseClass{

    //Shared Resource
    static Queue<Integer> queue = new LinkedList<>();

    @Override
    public void doProcess() {
        Thread consumer = new Thread(new Consumer());
        Thread producer = new Thread(new Producer());
        producer.start();
        consumer.start();
    }
}


//Writer
class Producer implements Runnable {

    @Override
    public void run() {
        for(int i = 1 ; i < 5 ; i++){
            System.out.println("Produced : "+i);
            synchronized (ProducerConsumer.queue) {
                ProducerConsumer.queue.add(i);
                ProducerConsumer.queue.notifyAll();
            }

        }
    }
}

//Reader
class Consumer implements Runnable {

    @Override
    public void run() {
        while (true){
            synchronized (ProducerConsumer.queue) {
                try {
                    ProducerConsumer.queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (!ProducerConsumer.queue.isEmpty()) {
                    System.out.println("Consumed : " + ProducerConsumer.queue.remove());
                }
            }
        }
    }
}


