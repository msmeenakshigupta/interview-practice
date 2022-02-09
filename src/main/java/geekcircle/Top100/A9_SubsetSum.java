package com.geekcircle.Top100;

import java.util.LinkedHashMap;
import java.util.Map;

public class A9_SubsetSum {
    public static void main(String[] args) {
        int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23};
        int n = 15;
        //subsetSum(arr, n);
        subsetSumOptimized(arr, n);
    }

    private static void subsetSum(int[] arr, int K){
        for(int i = 0; i < arr.length; i++){
            int sum = 0;
            for(int j = i; j < arr.length; j++){
                sum+=arr[j];
                if(sum == K){
                    System.out.println("Found "+i+" to "+j);
                }
            }
        }
    }

    private static void subsetSumOptimized(int[] arr, int K){
        Map<Integer, Integer> lookup = new LinkedHashMap<>();
        lookup.put(0, -1);
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(lookup.containsKey(sum - K)){
                System.out.println("Found from "+(lookup.get(sum-K)+1) + " "+i);
                lookup.put(sum, i);
            }
            lookup.put(sum, i);
        }
    }


}
