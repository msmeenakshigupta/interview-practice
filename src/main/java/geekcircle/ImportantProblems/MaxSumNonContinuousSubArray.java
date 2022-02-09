package com.geekcircle.ImportantProblems;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-09
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class MaxSumNonContinuousSubArray {
    public static void main(String[] args) {
        int[] arr = { 1, -2, 6, 4, -3, 2, -4, -3 };
        int inc = arr[0];
        int exc = 0;
        int new_exc = 0;
        for(int i = 1; i < arr.length; i++){
            new_exc = Integer.max(inc, exc);
            inc = exc + arr[i];
            exc = new_exc;
        }
        System.out.println(Integer.max(inc, exc));
    }
}
