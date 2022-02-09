package com.geekcircle.Top100;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-26
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.LinkedHashMap;
import java.util.Map;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 3, 3, 1, -4 };
        int K = 7;
        subArrayWithGivenSum1(arr, K);
    }

    private static void subArrayWithGivenSum(int[] arr, int K){
        Map<Integer, Integer> lookup = new LinkedHashMap<>();
        lookup.put(0,-1);
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(lookup.containsKey(sum - K)){
                System.out.println("from "+(lookup.get(sum-K)+1)+ " to "+(i));
                //break;
            }
            lookup.put(sum, i);
        }
    }

    private static void subArrayWithGivenSum1(int[] arr, int K){
        for(int i = 0; i < arr.length; i++){
            int sum = 0;
            for(int j = i; j < arr.length; j++){
                sum += arr[j];
                if(sum == K){
                    for(int k = i; k <= j; k++){
                        System.out.print(arr[k]+" ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
