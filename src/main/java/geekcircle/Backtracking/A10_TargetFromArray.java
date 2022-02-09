package com.geekcircle.Backtracking;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-12
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class A10_TargetFromArray {
    public static void main(String[] args) {
        int[] arr = { 2, 7, 4, 0, 9, 5, 1, 3 };
        findSum(arr, 0, 20, 0, 4, "");
    }

    private static void findSum(int[] arr, int s, int sum, int i, int n, String str){
        if(i > arr.length){
            return;
        }

        if(n == 0){
            if(sum == s){
                System.out.println(str);
            }
            return;
        }
        //Consider
        if(i < arr.length){
            //Consider Current element
            findSum(arr, s+arr[i], sum,i+1, n-1, str + " " + arr[i]);

            //Don't consider current element
            findSum(arr, s, sum, i+1, n, str);
        }
    }
}