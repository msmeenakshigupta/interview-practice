package com.geekcircle.TopClassicalProblems;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-01
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.HashMap;
import java.util.Map;

public class KnapsackProblem01 {

    public static void main(String[] args) {
        int[] value = { 20, 5, 10, 40, 15, 25 };
        int[] weight = { 1, 2, 3, 8, 7, 4 };
        int W = 12;
        Map<String, Integer> lookup = new HashMap<>();
        System.out.println(knapsack(value, weight, value.length - 1, W, lookup));
        System.out.println("Iterations : " + iterations);
    }

    static int iterations = 0;

    static int knapsack(int[] value, int[] weight, int n, int W, Map<String, Integer> lookup) {
        iterations++;
        if (n < 0) {
            return 0;
        }

        int include = 0;
        int exclude = 0;
        if (W - weight[n] >= 0) {
            String key = (n - 1) + "|" + (W - weight[n]);
            if (lookup.containsKey(key)) {
                include = lookup.get(key);
            } else {
                include = value[n] + knapsack(value, weight, n - 1, W - weight[n], lookup);
                lookup.put(key, include);
            }
        }
        String key = (n - 1) + "|" + W;
        if (lookup.containsKey(key)) {
            exclude = lookup.get(key);
        } else {
            exclude = knapsack(value, weight, n - 1, W, lookup);
            lookup.put(key, exclude);
        }
        return Integer.max(include, exclude);
    }

}
