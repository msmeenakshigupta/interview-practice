package com.geekcircle.ImportantProblems;

import java.util.Arrays;

public class AllPermutations {
    public static void main(String[] args) {
        String str = "ABC";
        printAllPermutations(str.toCharArray(), 0, str.length(), "");
    }

    private static void printAllPermutations(char[] chars, int i, int n, String s){
        if(i == n){
            System.out.println(s);
            return;
        }
        for(int j = i; j < n; j++ ){
            char[] cc = Arrays.copyOf(chars, chars.length);
            char c = cc[i];
            cc[i] = cc[j];
            cc[j] = c;
            printAllPermutations(cc, i+1, n, new String(cc));
        }
    }
}
