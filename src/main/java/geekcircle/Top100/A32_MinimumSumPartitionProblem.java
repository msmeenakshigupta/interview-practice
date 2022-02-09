package com.geekcircle.Top100;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-04
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A32_MinimumSumPartitionProblem {
    public static void main(String[] args) {
        int[] arr = {10, 20, 15, 5, 25 };
        minimumSumPartition(arr);
    }

    private static void minimumSumPartition(int[] arr){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Arrays.sort(arr);
        int i = 0;
        int sum1 = 0;
        int sum2 = 0;
        while (i < arr.length){
            if(sum1 < sum2){
                sum1 += arr[i];
                list1.add(arr[i]);
            } else {
                sum2 += arr[i];
                list2.add(arr[i]);
            }
            i++;
        }
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(Math.abs(sum2-sum1));
    }
}
