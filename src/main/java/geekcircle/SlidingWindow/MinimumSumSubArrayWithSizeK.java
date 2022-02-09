package com.geekcircle.SlidingWindow;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-01
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class MinimumSumSubArrayWithSizeK {

    //Self Solution
    public static void main(String[] args) {
        int[] arr = {10, 4, 2, 5, 6, 3, 8, 1};
        int i = 0;
        int j = 0;
        int k = 3;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (j < arr.length){
            if((j-i) < k){
                sum += arr[j++];
            } else {
                sum += (arr[j++] - arr[i++]);
            }
            if((j-i) == k && min > sum){
                min = sum;
                System.out.println("["+i+","+(j-1)+"] is "+min);
            }
        }
        System.out.println(min);
    }
}
