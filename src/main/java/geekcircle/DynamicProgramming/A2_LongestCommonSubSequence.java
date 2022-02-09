package com.geekcircle.DynamicProgramming;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-19
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class A2_LongestCommonSubSequence {
    public static void main(String[] args) {
        String s1 = "ABCBDAB";
        String s2 = "BDCABA";
        Integer largest = LongestCommonSubSequence(s1.toCharArray(), s2.toCharArray(), s1.length()-1, s2.length()-1, "");
        System.out.println(largest);
    }

    //Brute Force
    private static int LongestCommonSubSequence(char[] str1, char[] str2, int i, int j, String s){
        if(i == 0 || j == 0){
            System.out.println(s);
            return 0;
        }

        if(str1[i] == str2[j]){
            return 1 + LongestCommonSubSequence(str1, str2, i-1, j-1, s+str1[i]);
        } else {
            return Integer.max(LongestCommonSubSequence(str1, str2, i-1, j, s),LongestCommonSubSequence(str1, str2, i, j-1, s));
        }
    }

    //Optimized

}
