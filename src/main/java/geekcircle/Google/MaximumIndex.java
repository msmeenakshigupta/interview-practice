package com.geekcircle.Google;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-16
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class MaximumIndex {
    public static void main(String[] args) {
        int[] arr ={34,8,10,3,2,80,30,33,1};
        maxIndexSol2(arr);
    }


    //Solution 1. Brute Force Approach O(n^2)
    private static void maxIndexSol1(int[] arr){
        int n = arr.length;
        int max = -1;
        for(int i = 0; i < n; i++){
            for(int j = n-1; i < j; j--){
                if(arr[j] > arr[i] && max < (j-i)){
                    max = (j-i);
                }
            }
        }
        System.out.println(max);
    }

    //Solution 2. Optimized
    private static void maxIndexSol2(int[] arr){
        int n = arr.length;
        int maxDiff;
        int i, j;

        int RMax[] = new int[n];
        int LMin[] = new int[n];

        LMin[0] = arr[0];
        for (i = 1; i < n; ++i)
            LMin[i] = Integer.min(arr[i], LMin[i - 1]);

        RMax[n - 1] = arr[n - 1];
        for (j = n - 2; j >= 0; --j)
            RMax[j] = Integer.max(arr[j], RMax[j + 1]);

        i = 0; j = 0; maxDiff = -1;
        while (j < n && i < n)
        {
            if (LMin[i] < RMax[j])
            {
                maxDiff = Integer.max(maxDiff, j - i);
                j = j + 1;
            }
            else
                i = i + 1;
        }

        System.out.println(maxDiff);;
    }
}
