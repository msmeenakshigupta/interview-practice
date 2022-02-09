package com.geekcircle.Practice;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-06
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TriplateSum {
    public static void main(String[] args) {

        int[] arr = { 2, 7, 4, 0, 9, 5, 1, 3};
        int sum = 6;
        //triplate(arr, 4, 0, sum, "");
        tripleSum(arr, sum);
    }

    //Complexity
    private static void triplate(int[] arr, int n, int c, int sum, String str){
        if(n == 0){
            if(sum == 0){
                System.out.println(str);
            }
            return;
        }

        if(c < arr.length){
            //Include
            triplate(arr, n-1, c+1, sum - arr[c], str +" "+arr[c]);

            //Exclude
            triplate(arr, n, c+1, sum, str);
        }
    }

    private static void tripleSum(int[] arr, int sum){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], i);
        }

        for(int i = 0; i < arr.length-1; i++){
            for(int j = i+1;  j < arr.length; j++){
                int n = sum - (arr[i] + arr[j]);
                if(map.containsKey(n) && i != map.get(n) && j != map.get(n)){
                    System.out.println("Found on index : " + i + "," + j+","+map.get(n));
                }
            }
        }
    }
}
