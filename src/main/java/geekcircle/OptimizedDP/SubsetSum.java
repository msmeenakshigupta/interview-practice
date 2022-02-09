package com.geekcircle.OptimizedDP;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-22
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {2,3,7,8,10};
        int k = 11;

        //System.out.println(subsetSum(arr, k, arr.length-1, ""));
        System.out.println(subsetSumTabulation(arr, k));
    }

    private static boolean subsetSum(int[] arr, int k, int n, String s){
        if(k == 0) {
            System.out.println(s);
            return true;
        }

        boolean include = false;
        boolean exclude = false;
        if(n >= 0){
            include = subsetSum(arr, k - arr[n], n-1, arr[n]+" "+s);
            exclude = subsetSum(arr, k, n-1, s);
        }
        return include | exclude;
    }

    private static boolean subsetSumTabulation(int[] arr, int k){
        int N = arr.length;
        boolean[][] lookup = new boolean[N+1][k+1];
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < k+1; j++){
                if(lookup[i-1][j]){
                    lookup[i][j] = true;
                } else if(arr[i-1] <= j){
                    int remaining = j - arr[i-1];
                    if(remaining != 0){
                        lookup[i][j] = lookup[i-1][remaining];
                    } else {
                        lookup[i][j] = true;
                    }
                } else {
                    lookup[i][j] = lookup[i-1][j];
                }
            }
        }

        System.out.print("\t");
        for(int j = 0; j < k+1; j++){
            System.out.print(j +"\t");
        }
        System.out.println();
        for(int i = 0; i < N+1;i++) {
            if(i != 0){
                System.out.print(arr[i-1] +"\t");
            } else {
                System.out.print("\t");
            }
            for (int j = 0; j < k + 1; j++) {
                System.out.print(((lookup[i][j]) ? "T" : "F") +"\t");
            }
            System.out.println();
        }

        return true;
    }
}
