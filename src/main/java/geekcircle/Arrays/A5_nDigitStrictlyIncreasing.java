package com.geekcircle.Arrays;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-02
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class A5_nDigitStrictlyIncreasing {

    public static void main(String[] args) {
        int n = 7;
        strictlyIncreasing("", n, '0');
    }

    private static void strictlyIncreasing(String str, int n, char prev){

        if (n == 0) {
            System.out.println(str);
            return;
        }

        for (char ch = (char)(prev + 1); ch <= '9'; ch++) {
            strictlyIncreasing(str + ch, n - 1, ch);
        }
    }

}
