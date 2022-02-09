package com.geekcircle.OptimizedDP;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-22
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class RodCuttingProblem {
    public static void main(String[] args) {
        int[] lengths = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int k = 4;
        System.out.println(rodLength(lengths, price, k));
    }

    public static int rodLength(int[] lengths, int[] prices, int k){
        if(k == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < lengths.length; i++){
            if(k-lengths[i] >= 0){
                int v = prices[i]+rodLength(lengths, prices, k - lengths[i]);
                Integer.max(max, v);
            }
        }
        return max;
    }
}
