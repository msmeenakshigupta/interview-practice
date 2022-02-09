package com.geekcircle.Top100;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-30
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubSequenceProblem {

    /*
    The longest common subsequence (LCS) problem is the problem of
    finding the longest subsequence that is present in given
    two sequences in the same order. i.e.
    find a longest sequence which can be obtained from the first original
    sequence by deleting some items, and from the second original sequence by
    deleting other items.
     */

    //Incomplete
    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABA";
        Map<String, Integer> lookup = new HashMap<>();
        System.out.println(commonSubSequence(X, Y, X.length()-1, Y.length()-1, lookup));
    }

    static int commonSubSequence(String X , String Y, int m, int n, Map<String, Integer> lookup){
        if(m == 0 || n == 0){
            return 0;
        }
        String key = m+"|"+n;
        int r = 0;
        if(lookup.containsKey(key)){
            r = lookup.get(key);
        } else {
            if(X.charAt(m) == Y.charAt(n)){
                r = commonSubSequence(X,Y,m-1, n-1, lookup) + 1;
            } else {
                int left = commonSubSequence(X,Y,m-1, n, lookup);
                int right = commonSubSequence(X,Y,m,n-1, lookup);
                r = left > right ? left : right ;
            }
        }
        return r;
    }
}