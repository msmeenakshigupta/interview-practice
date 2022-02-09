package com.geekcircle.Intuit;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-25
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

//Self Solution
public class A5_MaximumSum {
    public static void main(String[] args) {
        int[] arr = {5,-1,2,4};
        int prev = 0;
        int curr = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0){
                curr += arr[i];
            } else {
                prev = Integer.max(prev, curr);
                curr = 0;
            }
        }
        prev = Integer.max(curr, prev);
        System.out.println("Sum "+ prev);
    }
}
