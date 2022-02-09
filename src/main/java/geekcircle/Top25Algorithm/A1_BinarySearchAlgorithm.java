package com.geekcircle.Top25Algorithm;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-01
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class A1_BinarySearchAlgorithm {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7, 9}; //Always Sorted
        int k = 10;
        System.out.println(binarySearch(arr, 0, arr.length -1, k));
    }

    static int binarySearch(int[] arr, int l, int r, int k){
        if(l > r){
            return -1;
        }

        int m = l + (int) (r - l)/2;
        if(arr[m] == k){
            return m;
        } else if (arr[m] > k){
            return binarySearch(arr, l, m-1, k);
        } else if (arr[m] < k) {
            return binarySearch(arr, m+1, r, k);
        }
        return -1;
    }
}
