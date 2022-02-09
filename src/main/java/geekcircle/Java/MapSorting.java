package com.geekcircle.Java;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-13
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.*;
import java.util.Map.Entry;

public class MapSorting {
    public static void main(String[] args) {


        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int i = 10; i >= 0; i--){
            double j = Math.random();
            map.put((int)(j * 100), i);
        }

        map = sort(map);

        System.out.println(map);
    }

    //Sort Map
    private static Map<Integer, Integer> sort(Map<Integer, Integer> map) {

        Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2 ) {
                return o1.getValue() - o2.getValue();
            }
        };

        Set<Map.Entry<Integer, Integer>> set = new TreeSet<>(comparator);
        set.addAll(map.entrySet());

        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<Integer, Integer> entry : set){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }


}
