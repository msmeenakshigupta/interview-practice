package com.geekcircle.Microsoft;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-18
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.HashSet;
import java.util.Set;

public class A1_PairSum {
    public static void main(String[] args) {
        int[] arr = {1,6,45,8,10,6};
        int sum = 16;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            if(set.contains(sum - arr[i])){
                System.out.println(arr[i] +" "+ (sum - arr[i]));
            }
            set.add(arr[i]);
        }
    }
}
