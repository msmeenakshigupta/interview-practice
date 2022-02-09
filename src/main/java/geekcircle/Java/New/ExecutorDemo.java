package com.geekcircle.Java.New;

import com.geekcircle.Java.SystemDesign.RateLimiterMethodClass.Bar;
import com.geekcircle.Java.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorDemo {

    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(()-> {
            try {
                for(int i = 0; i < 10; i++){
                    System.out.println("Task 1");
                }
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        es.submit(()-> {
            try {
                for(int i = 0; i < 10; i++){
                    Object o1 = new Bar();
                    Object o2 = new Bar();
                    System.out.println("Task 2");
                }
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        es.shutdownNow();
    }
}
