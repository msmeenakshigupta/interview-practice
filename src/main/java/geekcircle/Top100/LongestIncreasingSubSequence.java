package com.geekcircle.Top100;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-30
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestIncreasingSubSequence {

    public static void main(String[] args) {
        int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        Map<String, Integer> lookup = new HashMap<>();
        System.out.println(longestIncreasingSubSequence(arr, 0, -1, lookup));
    }

    static int longestIncreasingSubSequence(int[] arr, int n, int prev, Map<String, Integer> lookup){
        if(n == arr.length){
            return 0;
        }

        String key = n+"|"+prev;
        int r = 0;
        if(lookup.containsKey(key)){
            r = lookup.get(key);
        } else {
            int include = 0;
            int exclude = longestIncreasingSubSequence(arr, n+1, prev, lookup);
            if(prev < arr[n]){
                include = 1 + longestIncreasingSubSequence(arr, n+1, arr[n], lookup);
            }

            r = Integer.max(include, exclude);
            lookup.put(key, r);
        }
        return r;
    }

}
