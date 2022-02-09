package com.geekcircle.Java;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-13
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(1);
        List<String> files = new ArrayList<>();
        files.add("File1");
        files.add("File2");
        files.add("File3");
        files.add("File4");
        files.add("File5");
        files.add("File6");

        for (String path: files) {
            es.execute(() -> { task(path); });
        }
        es.shutdownNow();
    }

    public static void task(String path){
        try {
            Thread.sleep(1000);
            System.out.println("File : "+path+" Executed by thread : "+Thread.currentThread().getName());
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
