package com.geekcircle.Recursion_Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-11
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class A16_NumberToAlphabet {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1};
        numberToAlphabet(arr, 0,"");
    }

    private static void numberToAlphabet(int[] arr, int n, String str){
        if(n >= arr.length){
            System.out.println(str);
            return;
        }

        numberToAlphabet(arr, n+1, str+""+(char)(arr[n]+(int)('A')-1));
        if(n+1 < arr.length){
            int include = Integer.valueOf(arr[n] +""+ arr[n+1]);
            if(include <= 26){
                numberToAlphabet(arr, n+2, str+""+(char)(include+(int)('A')-1));
            }
        }

    }
}
