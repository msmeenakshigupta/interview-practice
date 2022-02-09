package com.geekcircle.Payu;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-26
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class A1_ReverseEachWordInString {
    public static void main(String[] args) {
        String str = "ijk.like.this.program.very.much";
        char[] ch = str.toCharArray();
        int i = 0;
        int j = 0;
        while (i < str.length()){
            while(j < str.length() && ch[j] != '.'){
                j++;
            }
            int b = i;
            for(;i < b+((j-i+1)/2)+1; i++){
                char c = ch[i];
                ch[i] = ch[b+(j-i-1)];
                ch[b+(j-i-1)] = c;
            }

            while (j < str.length() && ch[j] == '.'){
                j++;
            }
            i = j;
        }
        System.out.println(new String(ch));
    }
}
