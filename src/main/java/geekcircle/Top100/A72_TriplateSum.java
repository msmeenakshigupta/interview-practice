package com.geekcircle.Top100;

import java.util.Arrays;

public class A72_TriplateSum {
    public static void main(String[] args) {
        int[] arr = { 2, 7, 4, 0, 9, 5, 1, 3};
        int sum = 6;
        triplateSum(arr, sum);
    }

    private static void triplateSum(int[] arr, int sum){
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            int remainingSum = sum - arr[i];
            int j = i+1, k = arr.length-1;
            while (j < k){
                int tSum = arr[j]+arr[k];
                if(tSum == remainingSum){
                    System.out.println("("+i+","+j+","+k+")");
                    j++;
                    k--;
                } else if (tSum > remainingSum) {
                    k--;
                } else {
                    j++;
                }
            }
        }
    }


}
