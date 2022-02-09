package com.geekcircle.String;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-25
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.*;

public class firstNonRepeatingCharInString {

    public static void main(String[] args) {
        int x = 123;
            String s = Integer.toString(x);
            char[] ch = s.toCharArray();
            int n = ch.length;
            for(int i = 0; i < n/2; i++){
                char c = ch[i];
                ch[i] = ch[n-i-1];
                ch[n-i-1] = c;
            }
            s = new String(ch);
            System.out.println(Integer.valueOf(s));
    }
}
