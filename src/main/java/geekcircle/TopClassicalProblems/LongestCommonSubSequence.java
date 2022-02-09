package com.geekcircle.TopClassicalProblems;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-01
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class LongestCommonSubSequence {

    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABA";
        System.out.println(longestCommonSubSequence(X,Y,X.length()-1, Y.length()-1));
    }

    static int longestCommonSubSequence(String X, String Y, int m, int n){
        if(m == 0 || n == 0){
            return 0;
        }

        if(X.charAt(m) == Y.charAt(n)){
            return longestCommonSubSequence(X, Y, m-1, n-1) + 1;
        }
        int x_s = longestCommonSubSequence(X, Y, m - 1, n);
        int y_s = longestCommonSubSequence(X, Y, m , n - 1);
        return Integer.max(x_s,y_s);
    }
}
