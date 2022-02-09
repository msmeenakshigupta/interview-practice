package com.geekcircle.Top100;

import java.util.Arrays;

public class A78_ReArrangeAlternateLowAndHigh {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        alternateLowToHigh(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void alternateLowToHigh(int[] arr){
        boolean less = true;
        for(int i = 0; i < arr.length-1; i++){
            if(less){
                if(arr[i] > arr[i+1]){
                    int t = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = t;
                }
            } else {
                if(arr[i] < arr[i+1]){
                    int t = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = t;
                }
            }
            less = !less;
        }
    }
}
