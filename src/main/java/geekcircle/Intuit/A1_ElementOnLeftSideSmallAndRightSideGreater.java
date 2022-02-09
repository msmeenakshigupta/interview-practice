package com.geekcircle.Intuit;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-24
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class A1_ElementOnLeftSideSmallAndRightSideGreater {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 3, 6, 8, 10, 7, 9};
        System.out.println(elementOnLeftSideSmallAndRightSideGreater(arr));
    }

    private  static int elementOnLeftSideSmallAndRightSideGreater(int[] arr){
        int n = arr.length;
        int[] minArr = new int[n];
        int[] maxArr = new int[n];
        for(int i = 0; i < n; i++){
            if(i == 0){
                minArr[n - i - 1] = arr[n - i - 1];
                maxArr[i] = arr[i];
            } else {
                maxArr[i] = Integer.max(arr[i], maxArr[i-1]);
                minArr[n - i - 1] = Integer.min(arr[n - i - 1], minArr[n - i]);
            }
        }

        int found = -1;
        for(int i = 1; i < n-1; i++){
            if(maxArr[i-1] < arr[i] && minArr[i+1] > arr[i]){
                found = i;
            }
        }
        return found;
    }

}
