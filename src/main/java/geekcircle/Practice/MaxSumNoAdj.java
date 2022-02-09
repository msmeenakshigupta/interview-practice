package com.geekcircle.Practice;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-06
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class MaxSumNoAdj {
    public static void main(String[] args) {

        /*int[] arr = { 1, 2, 9, 4, 5, 0, 4, 11, 6 };

        int include = arr[0];
        int exclude = 0;
        int new_exclude = 0;

        for(int i = 1; i < arr.length; i++){
            new_exclude = Integer.max(include, exclude);

            include = exclude + arr[i];

            exclude = new_exclude;

        }
        System.out.println(Integer.max(include, exclude));*/
        maxSumApproach1();
    }

    public static void maxSumApproach1 (){

        int[] arr = { 1, 2, 9, 4, 5, 0, 4, 11, 6 };

        if(arr.length == 0){
            System.out.println(0);
        }
        if(arr.length == 1){
            System.out.println(arr[0]);
        }

        int[] lookup = new int[arr.length];

        int prev_prev = arr[0];
        int prev = Integer.max(arr[0], arr[1]);

        for(int i = 2; i < arr.length; i++){
            int curr = Integer.max(prev, prev_prev+arr[i]);
            prev_prev = prev;
            prev = Integer.max(curr, arr[i]);
        }
        System.out.println(prev);

    }
}
