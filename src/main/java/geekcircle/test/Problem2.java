package com.geekcircle.test;

public class Problem2 {
    public static void main(String[] args) {
        //int[] arr = {7, 0, 4, 2, 5, 0, 6, 4, 0, 5};
        int[] arr = {3, 0, 2, 0, 4};
        System.out.println(waterTapping(arr));
    }

    private static int waterTapping(int[] arr){
        int n = arr.length;
        int sum = 0;
        int right[] = new int[n];
        right[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--){
            if(right[i+1] > arr[i]){
                right[i] = right[i+1];
            } else {
                right[i] = arr[i];
            }
        }

        int max = arr[0];
        for(int i = 0; i < n; i++){
            if(max < arr[i]){
                max = arr[i];
            }
            sum += Integer.min(max,right[i]) - arr[i];
        }
        return sum;
    }
}
