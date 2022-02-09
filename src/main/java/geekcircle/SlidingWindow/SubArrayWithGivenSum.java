package com.geekcircle.SlidingWindow;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-01
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class SubArrayWithGivenSum {

    //Self Solution
    public static void main(String[] args) {
        int[] arr = {0, 5, -7, 1, -4, 7, 6, 1, 4, 1, 10};
        int k = 15;
        int i = 0;
        int j = 0;
        int sum = 0;
        while (j < arr.length){
            sum += arr[j];
            if (sum > k)  {
                while (sum > k){
                    sum -= arr[i];
                    i++;
                }
            }
            j++;
            if(sum == k){
                for(int l = i; l < j ; l++){
                    System.out.print(arr[l]+" ");
                }
                System.out.println();
            }
        }
    }
}
