package com.geekcircle.Microsoft;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-18
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class KadanesAlgoContineousSum {
    public static void main(String[] args) {
        int[] arr = {-4,-2,-1,-4};
        int maxSoFar = arr[0];
        int maxEndHere = arr[0];
        for(int i = 1; i < arr.length; i++){
            maxEndHere += arr[i];
            if(maxSoFar < maxEndHere){
                maxSoFar = maxEndHere;
            }
            if(maxEndHere < 0){
                maxEndHere =0;
            }
        }
        System.out.println(maxSoFar);
    }
}
