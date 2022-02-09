package com.geekcircle.Arrays;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-02
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class A1_ReplaceEachElementWithProductOfOthers {

    //without division Operator
    public static void main(String[] args) {
        int[] arr = { 5, 3, 4, 2, 6, 8 };
        solutionWithDivide(arr);
    }

    public static void solutionWithDivide(int[] arr){
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        for(int i = 0; i < arr.length; i++ ){
            if(i == 0){
                left[i] = 1;
                right[arr.length - 1 - i] = 1;
            } else {
                left[i] = arr[i-1] * left[i -1];
                right[arr.length - 1 -i] = arr[arr.length - i] * right[arr.length - i];
            }
        }
        for(int i = 0; i < left.length; i++){
            System.out.print(left[i] * right[i] + " ");
        }
    }

}
