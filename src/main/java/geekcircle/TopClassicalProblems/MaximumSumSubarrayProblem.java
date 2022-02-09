package com.geekcircle.TopClassicalProblems;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-31
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class MaximumSumSubarrayProblem {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max_so_far = 0;
        int max_end_here = 0;
        int i = 0;
        while (i < arr.length){
            max_end_here += arr[i];
            if(max_so_far < max_end_here){
                System.out.println("Add : "+ i);
                max_so_far = max_end_here;
            }
            if(max_end_here < 0){
                System.out.println("Remove : "+ i);
                max_end_here = 0;
            }
            i++;
        }
        System.out.println(max_so_far);
    }
}
