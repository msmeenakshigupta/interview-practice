package com.geekcircle.Arrays;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-02
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class A4_MaxSumWithNoAdjacent {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 9, 4, 5, 0, 4, 11, 6 };
        approach2(arr);
    }

    private static void approach1(int[] arr){
        int include = arr[0];
        int exclude = 0;
        int newExclude = 0;
        for(int i = 1; i < arr.length; i++){
            newExclude = Integer.max(include, exclude);
            include = exclude + arr[i];
            exclude = newExclude;
        }
        System.out.println(Integer.max(include, exclude));
    }

    private static void approach2(int[] arr){
        int[] lookup = new int[arr.length];
        lookup[0] = arr[0];
        lookup[1] = Integer.max(arr[0], arr[1]);
        for(int i = 2; i < arr.length; i++){
            lookup[i] = Integer.max(lookup[i-1], lookup[i-2] + arr[i]);
            lookup[i] = Integer.max(lookup[i], arr[i]);
        }
        System.out.println(lookup[arr.length-1]);
    }


}
