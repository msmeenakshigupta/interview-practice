package com.geekcircle.Top25Algorithm;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-01
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class A4_MergeSortAlgorithm {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        mergeSort(arr, 0, arr.length-1);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void mergeSort(int[] arr, int l, int h){
        if(h == l){
            return;
        }
        int m = l + ((h-l)/2);
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, h);
        merge(arr, l, m+1, h);
    }

    private static void merge(int[] arr, int l, int m, int h){
        int[] temp = new int[h-l+1];
        int i = l;
        int j = m;
        int k = 0;
        while (i <= m && j <= h){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (m > i){
            temp[k++] = arr[i++];
        }

        while (h > j){
            temp[k++] = arr[j++];
        }

        k = 0;
        for(i = l; i <= h; i++){
            arr[i] = temp[k++];
        }
    }
}
