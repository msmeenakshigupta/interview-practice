package com.geekcircle.Top100;

import org.omg.CORBA.INTERNAL;

public class A70_MaxProductSubArray {
    public static void main(String[] args) {
        int[] arr =   { -6, 4, -5, 8, -10, 0, 8 };
        //System.out.println(maxProductSubArrayNaive(arr));
        System.out.println(maxProductSubArrayOptimized(arr));
    }

    private static int maxProductSubArrayNaive(int[] arr){
        int length = arr.length;
        if(length == 0){
            return 0;
        }
        if( length == 1){
            return arr[0];
        }
        int max = 1;
        for(int i = 0; i < length; i++){
            int product = arr[i];
            for(int j = i+1; j < length; j++){
                product *= arr[j];
                max = Integer.max(product, max);
            }
        }
        return max;
    }

    private static int maxProductSubArrayOptimized(int[] arr){
        int min = 1;
        int max = 1;
        int finalMax = 1;
        for(int i : arr){
            int t = max;
            max = Integer.max(i, Integer.max(min * i, max * i));
            min = Integer.min(i, Integer.min(t * i, min * i));
            finalMax = Integer.max(max, finalMax);
        }
        return finalMax;
    }
}
