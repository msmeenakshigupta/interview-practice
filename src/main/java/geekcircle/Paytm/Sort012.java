package com.geekcircle.Paytm;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-11
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {
        int[] arr = {0,1,1,0,2,1,0,1,2};
        System.out.println(Arrays.toString(arr));
    }

    private static void sortApp1(int[] arr){
        Arrays.sort(arr);
    }
    private static void sortApp2(int[] arr){
        int i =0;
        int j = arr.length-1;
        int k = 0;
        while(k <= j){
            if(arr[k] == 0){
                int t = arr[k];
                arr[k] = arr[i];
                arr[i] = t;
                i++;
                k++;
            } else if (arr[k] == 1) {
                k++;
            } else if(arr[k] == 2) {
                int t = arr[k];
                arr[k] = arr[j];
                arr[j] = t;
                j--;
            }
        }
    }
}
