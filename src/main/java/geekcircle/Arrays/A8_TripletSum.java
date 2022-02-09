package com.geekcircle.Arrays;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-02
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class A8_TripletSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 0, 9, 5, 1, 3};
        System.out.println(tripletSum(arr, arr.length, 14, 0, ""));
    }

    //Tree Approach (Recursive)
    static boolean tripletSum(int[] arr, int n, int sum, int count, String num){
        if(count == 3 && sum == 0){
            System.out.println(num);
            return true;
        }

        if(count == 3 || n == 0 || sum < 0){
            return false;
        }

        boolean left = tripletSum(arr, n - 1, sum - arr[n-1], count++, num+arr[n-1]+" ");
        boolean right = tripletSum(arr, n - 1, sum, count, num);
        return  left || right;
    }
}
