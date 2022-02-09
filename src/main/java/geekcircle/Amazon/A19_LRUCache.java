package com.geekcircle.Amazon;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-17
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.*;

public class A19_LRUCache {
    private static Map<Integer,Integer> cache;
    private static Integer N;

    private A19_LRUCache(int cap) {
        cache = new LinkedHashMap<>(cap);
        N = cap;
    }

    public int get(int key) {
        Integer i = cache.get(key);
        if(i == null){
            i = -1;
        }
        return i;
    }

    public void set(int key, int value) {
        Set<Integer> set = cache.keySet();
        Integer i = cache.get(key);
        if(i != null){
            cache.remove(key);
            cache.put(key, value);
        } else {
            if(set.size() == N){
                for(Integer j : set){
                    cache.remove(j);
                    break;
                }
            }
            cache.put(key, value);
        }

    }

    public static void main(String[] args) {
        A19_LRUCache a = new A19_LRUCache(2);
        a.set(1,2);
        a.set(2,3);
        a.set(1,5);
        a.set(4,5);
        a.set(6,7);
        System.out.println(a.get(4));
        System.out.println(a.get(1));
    }
}
