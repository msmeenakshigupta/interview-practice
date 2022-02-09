package com.geekcircle.SlidingWindow;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-01
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.HashSet;
import java.util.Set;

public class DistinctElementInSubArray {

    //Self Solution
    public static void main(String[] args) {
        int[] arr = { 2, 1, 2, 3, 2, 1, 4, 5 };
        int k = 5;
        for(int i = 0; i <= arr.length - k; i++){
            Set<Integer> set = new HashSet<>();
            System.out.println("From : "+i+" to: "+(i+k-1));
            for(int j = i; j < i+k; j++){
                set.add(arr[j]);
            }
            System.out.println(set.size());
        }
    }
}
