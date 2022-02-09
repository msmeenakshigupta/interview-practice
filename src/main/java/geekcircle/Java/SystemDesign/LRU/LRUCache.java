package com.geekcircle.Java.SystemDesign.LRU;

import java.util.*;

public class LRUCache {
    final static int PAGES = 5;
    private static Map<Integer, Integer> cache = new LinkedHashMap<>();
    private static int currentSize = 0;

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1,2,3,3,5,6,4,3,5,7};
        for(int i = 0; i < arr.length; i++){
            addToCache(arr[i]);
            printCache();
        }
    }

    private static void printCache(){
        System.out.println(cache);
    }

    private static void addToCache(int val){
        System.out.println("Add : "+val);
        Integer i = cache.get(val);
        if(i == null){
            if(currentSize == PAGES){
                Set<Integer> set = cache.keySet();
                for(Integer j : set){
                    cache.remove(j);
                    currentSize--;
                    break;
                }
            }
            cache.put(val, val);
            currentSize++;
        } else {
            cache.remove(val);
            cache.put(val, val);
        }

    }

}
