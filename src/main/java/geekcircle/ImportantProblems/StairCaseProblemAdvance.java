package com.geekcircle.ImportantProblems;

import java.util.Arrays;

public class StairCaseProblemAdvance {
    public static void main(String[] args) {
        int N = 10;
        int[] k = {2,3};
        System.out.println(stairCaseProblem(N, k));
    }

    private static int stairCaseProblem(int N, int[] k){
        int[] arr = new int[N+1];
        arr[0] = 1;
        int min = 2;
        for(int i : k){
            min = Math.min(i, min);
        }
        arr[1] = (min == 1) ? 1 : 0;
        for(int i = 2; i < N+1; i++) {
            int sum = 0;
            for(int l : k){
                if(i-l >= 0){
                    sum += arr[i-l];
                }
            }
            arr[i] = sum;
        }
        System.out.println(Arrays.toString(arr));
        return arr[N];
    }
}
