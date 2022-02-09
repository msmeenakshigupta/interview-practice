package com.geekcircle.Java;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-13
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableExample {

    public static void main(String[] args) {

        List<Future<Integer>> futures = new ArrayList<>();

        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(1000);
                return getNumber();
            }
        };

        ExecutorService es = Executors.newFixedThreadPool(2);

        for(int i = 0; i < 10; i++){
            futures.add(es.submit(callable));
        }

        for(int i = 0; i < futures.size(); i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(futures.get(i).isDone());
        }

        es.shutdown();
    }

    static int num = 10;
    private static int getNumber(){
        return num++;
    }
}
