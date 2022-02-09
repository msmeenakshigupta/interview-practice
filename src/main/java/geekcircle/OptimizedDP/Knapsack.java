package com.geekcircle.OptimizedDP;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-22
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class Knapsack {
    public static void main(String[] args) {
        int[] profits = {20,5,10,40,15,25};
        int[] weights =  {1,2,3,8,7,4};
        int W = 10;
        System.out.println(knapsack01Tabular(profits, weights, W));
        System.out.println(knapsack01Tree(profits, weights, W, profits.length-1));
    }

    //Tabular Method O(N*W)
    private static int knapsack01Tabular(int[] profits, int[] weights, int W){
        int n = profits.length;
        int[][] lookup = new int[n+1][W+1];
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < W+1; j++){
                if(weights[i-1] <= j){
                    int remainingWeight = j - weights[i-1];
                    int profitFromCurrent = profits[i-1] + lookup[i-1][remainingWeight];
                    lookup[i][j] = (profitFromCurrent > lookup[i-1][j]) ? profitFromCurrent : lookup[i-1][j];
                } else {
                    lookup[i][j] = lookup[i-1][j];
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < W+1; j++){
                System.out.print(lookup[i][j] + "\t");
            }
            System.out.println();
        }
        return 0;
    }

    //Tree Approach
    private static int knapsack01Tree(int[] profits, int[] weights, int W, int n){
        if(W <= 0 || n < 0){
            return 0;
        }
        int include = 0;
        if(weights[n] <= W){
            System.out.println("Include profit: "+profits[n] + " remaining W : "+(W - weights[n]));
            include = profits[n] + knapsack01Tree(profits, weights, W - weights[n], n-1);
        }
        int exclude = knapsack01Tree(profits, weights, W, n-1);
        return Integer.max(include, exclude);
    }
}
