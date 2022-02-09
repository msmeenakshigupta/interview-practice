package com.geekcircle.Google;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-16
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class A5_JumpingNumber {
    public static void main(String[] args) {
        int n = 2;
        for(int i = 1; i <= 9; i++){
            jumping(n, i, "");
        }


    }

    private static void jumping(int n, int prev, String s){
        if(n == 0){
            System.out.println(s);
            return;
        }
        for(int i = 1; i <= 9; i++){
            if(Math.abs(prev-i) ==1){
                jumping(n-1,i,s+""+i);
            }
        }
    }
}
