package com.geekcircle.Intuit;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-24
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.Arrays;

public class A4_findAnagrams {
    public static void main(String[] args) {
        String str = "aabaabaa";
        String subStr = "aaba";
        char[] sub = subStr.toCharArray();
        Arrays.sort(sub);
        int n = str.length();
        int m = subStr.length();
        int ctr = 0;
        for(int i = 0; i < n - m+1; i++){
            char[] s = str.substring(i,i+m).toCharArray();
            Arrays.sort(s);
            boolean match = true;
            for(int j = 0; j < m; j++){
                if(sub[j] != s[j]){
                    match = false;
                    break;
                }
            }
            if(match){
                System.out.println(str.substring(i,i+m)+" ");
            }
        }
        System.out.println(ctr);
    }
}
