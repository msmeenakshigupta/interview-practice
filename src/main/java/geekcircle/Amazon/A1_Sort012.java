package com.geekcircle.Amazon;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-16
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class A1_Sort012 {
    public static void main(String[] args) {
        int[] arr = {1,0,1,0,1,2,0,2,0};
        sort012Sol2(arr, arr.length);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    //Solution 1 : move all 2 in one side first and then sort all 0-1
    //Analysis: move all will take n time and 0-1 sort will take another n time O(2n) ~ O(n)
    private static void sort012(int[] arr){
        int n = arr.length;
        int i = n-1; int j = n-1;
        while(i >= 0){
            while (j >= 0 && arr[j] == 2){
                j--;
            }

            while (i >= 0 && arr[i] != 2){
                i--;
            }

            if(i >= 0){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        i = 0;
        while(i < j){
            while ( i< j && arr[i] == 0){
                i++;
            }

            while (i < j && arr[j] != 0){
                j--;
            }

            if(i < j){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            }
        }
    }

    //Solution 2. Optimized Approach
    private static void sort012Sol2(int[] arr, int n){
        int i = 0;
        int j = n-1;
        int k = 0;
        while (k < j){
            if(arr[k] == 0){
                swap(arr, i, k);
                i++;
                k++;
            } else if(arr[k] == 1){
                k++;
            } else if(arr[k] == 2){
                swap(arr, k, j);
                j--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
