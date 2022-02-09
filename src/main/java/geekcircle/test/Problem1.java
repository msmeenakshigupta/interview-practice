package com.geekcircle.test;

public class Problem1 {
    public static void main(String[] args) {
        int[] arr = {10, 8, 6, 5, 4, 2};
        System.out.println(maxProfitEarned(arr));
    }

    private static int maxProfitEarned(int[] arr){
        int sum = 0;
        boolean buy = true;
        int b = 0;
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] < arr[i+1] && buy){
                b = arr[i];
                buy = !buy;
            } else if(arr[i] > arr[i+1] && !buy){
                buy = !buy;
                sum += (arr[i] - b);
                b = 0;
            }
        }
        if(b != 0 && arr[arr.length-1] > b){
            sum += (arr[arr.length-1] - b);
        }
        return sum;
    }
}
