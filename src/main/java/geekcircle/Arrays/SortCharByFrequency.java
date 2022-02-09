package com.geekcircle.Arrays;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-27
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.*;

public class SortCharByFrequency {

    public static void main(String[] args) {
        String s = "leet";
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i)+"")){
                map.put(s.charAt(i)+"",map.get(s.charAt(i)+"")+1);
            } else {
                map.put(s.charAt(i)+"",1);
            }
        }
        System.out.println(sortByValue(map));
    }

    static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        /*System.out.println(hm.entrySet());
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            @Override
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;*/



        List<Map.Entry<String, Integer>> list = new LinkedList<>(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        HashMap<String, Integer> map = new LinkedHashMap<>();
        for(Map.Entry<String, Integer> entry : list){
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

}
