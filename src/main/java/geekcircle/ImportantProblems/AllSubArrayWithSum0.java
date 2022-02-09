package com.geekcircle.ImportantProblems;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-09
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class AllSubArrayWithSum0 {
    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        int k = 0;
        sumToKApproach1(arr, k);
        sumToKApproach2(arr, k);
    }

    //Brute Force
    private static void sumToKApproach1(int[] arr, int k){
        System.out.println("Approach 1 :");
        for(int i = 0; i < arr.length; i++){
            int sum = 0;
            String str = "";
            for(int j = i; j < arr.length; j++){
                sum += arr[j];
                str = str +" "+ arr[j];
                if(sum == k){
                    System.out.println(str);
                    str = "";
                }
            }
        }
    }

    //Optimized Approach
    private static void sumToKApproach2(int[] arr, int k){
        System.out.println("Approach 2");
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum+=arr[i];
            if(map.containsKey(sum)){
                int ns = 0;
                for(int j = map.get(sum)+1; j < arr.length; j++ ){
                    System.out.print(arr[j]+" ");
                    ns+=arr[j];
                    if(ns == k){
                        break;
                    }
                }
                System.out.println("Found: "+(map.get(sum)+1));
            } else {
                map.put(sum, i);
            }
        }
    }

}
