package com.geekcircle.Flipkart;

import java.lang.reflect.Array;
import java.util.Arrays;

public class A7_NextGraterNumber {
    public static void main(String[] args) {
        String num = "218765";
        char[] arr = num.toCharArray();
        int n = num.length()-2;
        while (n-- > 0){
            if(arr[n] < arr[n+1]){
                char c = arr[n];
                arr[n] = arr[arr.length-1];
                arr[arr.length -1] = c;
                /*char[] substr = arr.toString();
                Arrays.sort(substr);
                for(int i = n+1; i < n+substr.length+1; i++){
                    arr[i] = substr[n+1-i];
                }*/
            }
        }
        System.out.println(arr);
    }
}
