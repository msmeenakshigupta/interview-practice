package com.geekcircle.SlidingWindow;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-01
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class FindLengthOfSmallestSubarrayWhoseSumIsGreater {

    //Self Solution
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 20;
        int i = 0;
        int j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (j < arr.length){
            if((sum+arr[j]) <= k){
                sum += arr[j];
                j++;
            } else {
                sum += arr[j];
                j++;
                while (sum > k){
                    sum -= arr[i];
                    for(int l = i; l < j; l++){
                        System.out.print(arr[l]+" ");
                    }
                    System.out.println();
                    min = Integer.min((j-i), min);
                    i++;
                }
            }
        }
        System.out.println("Min:"+min);
    }
}
