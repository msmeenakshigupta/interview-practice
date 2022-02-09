package com.geekcircle.SlidingWindow;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-31
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.HashSet;
import java.util.Set;

//Self Solution
public class FindDuplicateInRange {
    public static void main(String[] args) {
        int[] arr = { 5, 6, 8, 2, 4, 6, 9 };
        int k = 5;
        if(arr.length >= k){
            for(int i = 0; i < arr.length-k; i++){
                Set<Integer> set = new HashSet<>();
                for(int j = i; j < i+k; j++){
                    if(set.contains(arr[j])){
                        System.out.println("Duplicate "+ arr[j] + " in ["+i+","+(i+k-1)+"]");
                        return;
                    } else {
                        set.add(arr[j]);
                    }
                }
            }
        } else {
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j < arr.length; j++){
                if(set.contains(arr[j])){
                    System.out.println("Duplicate "+ arr[j] + " in ["+0+","+(arr.length-1)+"]");
                    return;
                } else {
                    set.add(arr[j]);
                }
            }
        }

        System.out.println("No Duplicate");
    }
}
