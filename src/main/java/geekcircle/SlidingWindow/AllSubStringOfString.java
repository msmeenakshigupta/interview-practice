package com.geekcircle.SlidingWindow;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-01
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.Map;

public class AllSubStringOfString {

    //Self Solution
    public static void main(String[] args) {
        String s1 = "XYYZXZYZXXYZ";
        String s2 = "XYZ";
        int[] ch1 = new int[26];
        int[] ch2 = new int[26];
        for(int i = 0; i < s2.length(); i++){
            ch2[s2.charAt(i)-'A'] += 1;
        }
        int i = 0;
        int j = 0;
        while (j < s1.length()){
            if(j-i < s2.length()){
                ch1[s1.charAt(j)-'A'] += 1;
                j++;
                if(j-i == s2.length()){
                    boolean found = true;
                    for(int k = 0 ; k < 26; k++){
                        if(ch1[k] != ch2[k]){
                            found = false;
                            break;
                        }
                    }
                    if(found){
                        System.out.println(s1.substring(i,j));
                    }
                }
            } else {
                ch1[s1.charAt(j)-'A'] += 1;
                j++;
                ch1[s1.charAt(i)-'A'] -= 1;
                i++;
                if(j-i == s2.length()){
                    boolean found = true;
                    for(int k = 0 ; k < 26; k++){
                        if(ch1[k] != ch2[k]){
                            found = false;
                            break;
                        }
                    }
                    if(found){
                        System.out.println(s1.substring(i,j));
                    }
                }
            }

        }
    }
}
