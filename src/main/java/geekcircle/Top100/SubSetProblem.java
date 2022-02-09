package com.geekcircle.Top100;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-30
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class SubSetProblem {

    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 5, 8};
        System.out.println(subSetProblem(arr, arr.length -1, 20));
    }

    static boolean subSetProblem(int[] arr, int n, int sum){
        if(sum == 0){
            return true;
        }

        if(n < 0 || sum < 0){
            return false;
        }


        boolean include = subSetProblem(arr, n -1, sum - arr[n]);
        boolean exclude = subSetProblem(arr, n-1, sum);

        return include | exclude;
    }

}
