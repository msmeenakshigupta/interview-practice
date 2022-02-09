package com.geekcircle.Hashing;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-03
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SubArrayWithZeroSum {
    public static void main(String[] args) {
        int[] arr = { -1,1,5,-3,6,2,-4-4,7 };
        System.out.println(subArrayWithZeroSum(arr));
    }

    private static boolean subArrayWithZeroSum(int[] arr){
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(7, -1);
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(map.containsKey(sum)){
                System.out.println((map.get(sum)+1)+" to "+ i);
                return true;
            }
            map.put(sum, i);
        }
        return false;
    }
}
