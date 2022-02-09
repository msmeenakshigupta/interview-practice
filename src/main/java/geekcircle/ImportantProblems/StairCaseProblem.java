package com.geekcircle.ImportantProblems;

import java.util.Arrays;

public class StairCaseProblem {
    public static void main(String[] args) {
        int N = 4;
        int k = 3;
        System.out.println(possibleWays(N, k));
    }


    private static int possibleWays(int N, int k){
        int[] arr = new int[N+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i < N+1; i++){
            int sum = 0;
            int ctr = k;
            for(int j = i-1; j >= 0 && ctr-- > 0; j--){
                sum += arr[j];
            }
            arr[i] = sum;
        }
        System.out.println(Arrays.toString(arr));
        return arr[N];
    }
}
