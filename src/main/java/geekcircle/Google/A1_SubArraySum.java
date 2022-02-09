package com.geekcircle.Google;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-16
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.HashMap;

public class A1_SubArraySum {
    public static void main(String[] args) {
        int[] arr = {8,9,10,1,2,3,4,5,6,7};
        //subArraySumSol1(arr, 15);
        subArraySumSol3(arr, 15);
    }

    //Solution 1, Brute Force Approach O(n^2)
    private static void subArraySumSol1(int[] arr, int sum) {
        int n = arr.length;
        for(int i = 0; i < n; i++ ){
            int s = 0;
            for(int j = i; j < n; j++){
                s += arr[j];
                if(s == sum){
                    System.out.println("From "+i+" to "+j);
                }
            }
        }
    }

    //Solution 2, Efficient Approach with Positive Numbers
    //Move with Sum, Greater then sum move i, small then sum move j
    private static void subArraySumSol2(int[] arr, int sum) {
        int n = arr.length;
        int i = 0;
        int j = 0;
        int s = 0;
        while (j < n){
            s += arr[j];
            while (s > sum){
                s -= arr[i++];
            }

            if(s == sum){
                System.out.println("From "+i+" to "+j);
            }
            j++;
        }
    }

    //Soultion 3, With Negative Numbers Memorize
    //http://geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
    private static void subArraySumSol3(int[] arr, int sum) {
        int n = arr.length;
        int cur_sum = 0;
        int start = 0;
        int end = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            cur_sum = cur_sum + arr[i];
            //check whether cur_sum - sum = 0, if 0 it means
            //the sub array is starting from index 0- so stop
            if (cur_sum - sum == 0) {
                start = 0;
                end = i;
                break;
            }
            //if hashMap already has the value, means we already
            // have subarray with the sum - so stop
            if (hashMap.containsKey(cur_sum - sum)) {
                start = hashMap.get(cur_sum - sum) + 1;
                end = i;
                break;
            }
            //if value is not present then add to hashmap
            hashMap.put(cur_sum, i);

        }
        // if end is -1 : means we have reached end without the sum
        if (end == -1) {
            System.out.println("No subarray with given sum exists");
        } else {
            System.out.println("Sum found between indexes "
                    + start + " to " + end);
        }

    }


}
