package com.geekcircle.Arrays;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-02
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class A2_AllDistinctCombinationOfGivenLength {
    public static void main(String[] args) {
        int[] arr = {1,2,3, 4, 5};
        int k = 3;
        printAllCombinationOfGivenLength(arr, "", 0, arr.length, k);
    }

    //Learn and revision Required
    static void printAllCombinationOfGivenLength(int[] arr, String output, int i, int n, int k){
        if(k == 0){
            System.out.println(output);
            return;
        }

        if(k < n) {
            for(int j = i; j < n; j++){
                printAllCombinationOfGivenLength(arr, output+" "+arr[j], j+1, n, k-1);
            }
        }

    }
}
