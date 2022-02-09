package com.geekcircle.ImportantProblems;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-09
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class MaxSumContinuousSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int max_so_far = 0;
        int max_ends_here = 0;
        for(int i = 0; i < arr.length; i++){
            max_ends_here += arr[i];
            if(max_so_far < max_ends_here){
                max_so_far = max_ends_here;
            }
            if(max_ends_here < 0){
                max_ends_here = 0;
            }
        }
        System.out.println(max_so_far);
    }
}
