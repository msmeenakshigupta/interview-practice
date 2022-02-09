package com.geekcircle.SlidingWindow;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-01
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.HashMap;
import java.util.Map;

public class AllSubArrayWithDistinctElements {

    //Self Solution
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = { 5, 2, 3, 5, 4, 3 };
        int i = 0;
        int j = 0;
        while(j < arr.length){
            if(map.containsKey(arr[j])){
                for(int k = i; k < j; k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
                while(map.containsKey(arr[j])){
                    map.remove(arr[i]);
                    i++;
                }
            }
            map.put(arr[j], 1);
            j++;
            if(j == arr.length){
                for(int k = i; k < j; k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
        }
    }
}
