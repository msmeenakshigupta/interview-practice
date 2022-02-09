package com.geekcircle.Practice;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-06
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Combination {

    public static void main(String[] args) {

        int[] arr = {1,2,3};
        Map<String, String> lookup = new LinkedHashMap<>();
        combination(arr, 0, 2, 0, "", lookup);
        System.out.println(comb);
    }

    static int comb = 0;
    private static void combination(int arr[], int c,  int n, int i, String str, Map<String, String> lookup){
        /*if(i == n){
            System.out.println(str);
            comb++;
            return;
        }*/

        if(c < arr.length) {
            //Include
            combination(arr, c+1,  n, i + 1, str +" "+arr[c], lookup) ;
            //Exclude
            combination(arr, c+1, n, i, str, lookup);
        } else {
            if(str.length() == 0){
                System.out.println("EMPTY");
            } else {
                System.out.println(str);
                comb++;
            }
        }
    }
}
