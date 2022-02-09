package com.geekcircle.Top100;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-30
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.HashMap;
import java.util.Map;

public class Knapsack01 {

    public static void main(String[] args) {
        int value[] = { 20, 5, 10, 40, 15, 25 };
        int weight[] = { 1, 2, 3, 8, 7, 4 };
        int W = 10;
        Map<String, Integer> lookup = new HashMap<>();
        System.out.println(knapsack01(value, weight, value.length-1, 10, lookup));
    }

    static int knapsack01(int[] v, int[] w, int n, int W, Map<String, Integer> lookup){

        if(W < 0){
            return Integer.MIN_VALUE;
        }

        if(n < 0 || W == 0){
            return 0;
        }

        String key = n + "|" + W;
        int max = 0;
        if(lookup.containsKey(key)){
            max = lookup.get(key);
        } else {
            int include = v[n] + knapsack01(v, w,n -1, W - w[n], lookup);

            int exclude = knapsack01(v, w,n-1, W, lookup);

            max = Integer.max(include, exclude);
            lookup.put(key, max);
        }
        return max;
    }
}
