package com.geekcircle.Arrays;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-27
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class LargestSumContineousSubArray {

    public static void main(String[] args) {

        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        //Brute Force
        int n = arr.length;
        /*int max = 0;
        for(int i = 0; i < n - 1; i++){
            int sum  = 0;
            for(int j = i+1; j < n; j++){
                sum += arr[j];
                if(max < sum){
                    max = sum;
                    System.out.println("i: "+arr[i+1]+", j: "+arr[j]);
                }
            }
        }*/

        //Optimized Approach if all are not negative
        int max = 0;
        int includeCurrent = 0;
        for(int i = 0; i < n; i++){
            includeCurrent += arr[i];
            if(max < includeCurrent){
                max = includeCurrent;
            }
            if(includeCurrent < 0){
                includeCurrent = 0;
            }
        }
        System.out.println(max);

        //If all negative


        /*for (int i = 0; i < arr.length; i++){
            if(max + arr[i] > max){

            }
        }*/

    }

}
