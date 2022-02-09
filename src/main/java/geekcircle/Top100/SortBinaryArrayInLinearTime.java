package com.geekcircle.Top100;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-30
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class SortBinaryArrayInLinearTime {

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1, 0, 0, 1 };
        sortBinaryArray(arr);
    }

    static void sortBinaryArray(int[] arr){
        int i = 0;
        int j = arr.length - 1;
        while (i < j){
            while(i < j && arr[i] == 0){
                i++;
            }
            while (i < j && arr[j] == 1){
                j--;
            }
            if(i < j){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        for(i = 0; i< arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
