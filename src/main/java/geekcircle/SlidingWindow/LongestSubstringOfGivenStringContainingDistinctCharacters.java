package com.geekcircle.SlidingWindow;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-01
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.Map;

public class LongestSubstringOfGivenStringContainingDistinctCharacters {

    //Self Solution
    public static void main(String[] args) {
        String str = "findlongestsubstring";
        int[] ch_arr = new int[26];
        int i = 0;
        int j = 0;
        int max = 0;
        String subString = null;
        while (j < str.length()){
            if(ch_arr[str.charAt(j)-'a'] == 0){
                ch_arr[str.charAt(j)-'a'] += 1;
                j++;
            } else {
                ch_arr[str.charAt(j)-'a'] += 1;
                while(ch_arr[str.charAt(j)-'a'] != 1){
                    ch_arr[str.charAt(i)-'a'] -= 1;
                    i++;
                }
                j++;
            }
            if(max < (j-i)){
                max = (j-i);
                subString = str.substring(i,j);
            }
        }
        System.out.println(subString);
    }
}
