package com.geekcircle.Intuit;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-24
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class A3_ProductArray {
    public static void main(String[] args) {
        int[] arr = {10,3,5,6,2};
        /*approach1(arr);
        approach2(arr);*/
        approach3(arr);
    }


    //Naive Approach 1 with divide operator
    private static void approach1(int[] arr){
        int product = 1;
        for(int i = 0; i < arr.length; i++){
            product *= arr[i];
        }
        for(int i = 0; i < arr.length; i++){
            System.out.println(product/arr[i]);
        }
    }

    //Naive Approach 2 without divide operator
    private static void approach2(int[] arr){
        int product = 1;
        for(int i = 0; i < arr.length; i++){
            int left = 1;
            int right = 1;
            for(int j = 0;j < i; j++){
                left *= arr[j];
            }
            for(int j = i+1;j < arr.length; j++){
                right *= arr[j];
            }
            System.out.println(left * right);
        }
    }

    //Optimized Approach
    private static void approach3(int[] arr){
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;
        for(int i = 0; i < n; i++){
            if(i != 0){
                left[i] = arr[i-1] * left[i-1];
                right[n-i-1] = arr[n-i] * right[n-i];
            }

        }
        for(int i = 0; i < n; i++){
            System.out.print(left[i]*right[i]+" ");
        }
        System.out.println();
    }
}
