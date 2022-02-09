package com.geekcircle.Top100;

import java.util.Arrays;

public class A61_InPlaceSortTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {1,4,7,8,10};
        int[] arr2 = {2,3,9};
        inPlaceSort(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    private static void inPlaceSort(int[] arr1, int[] arr2){
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length){
            while (arr1[i] < arr2[j]){
                i++;
            }
            int t = arr1[i];
            arr1[i] = arr2[j];
            arr2[j] = t;
            Arrays.sort(arr2);
            i++;
        }
    }
}
