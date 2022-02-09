package com.geekcircle.Practice;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-06
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class NDigitWithSum {
    public static void main(String[] args) {
        int n = 5;
        int sum = 42;
        digitSum(n, "" ,sum);
    }

    private static void digitSum(int n, String s, int sum){
        if(n == 0){
            if(sum  == 0){
                if(Integer.valueOf(s) > 100){
                    System.out.println(s);
                }
            }
            return;
        }

        for(int i = 0; i <= 9; i++){
            digitSum(n-1, s+""+i, sum -i);
        }
    }
}
