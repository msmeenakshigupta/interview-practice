package com.geekcircle.Practice;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-06
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class LongestDecreasingSubseq {

    public static void main(String[] args) {
        int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.println(decreasingSubSequence(arr, arr.length, 0, 0 , "", Integer.MAX_VALUE));
        System.out.println(result);
    }

    static int max = Integer.MIN_VALUE;
    static String result = "";
    private static int decreasingSubSequence(int[] arr, int n, int i, int d,  String s, int prev){
        if(i == n){
            if(max < d){
                max = d;
                result = s;
            }
            return 0;
        }

        int inc = 0;
        if(arr[i] < prev){
            inc = 1 + decreasingSubSequence(arr, n, i+1, d+1,s+ " "+arr[i], arr[i]);
        }
        int exc = decreasingSubSequence(arr, n, i+1, d, s, prev);
        return Integer.max(inc, exc);
    }

}
