package com.geekcircle.SlidingWindow;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-31
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinctChar {

    //Self Solution
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        String str = "abcbdbdbbdcdabd";
        int k = 5;
        int[] ch_arr = new int[26];
        int i = 0;
        int j = 0;
        int l = 0;
        int max = 0;
        String subString = null;
        while(j < str.length()){
            if(l < k){
                if(ch_arr[str.charAt(j)-'a'] == 0){
                    l++;
                }
                ch_arr[str.charAt(j)-'a'] = 1;
                j++;
            } else if (l == k) {
                if(ch_arr[str.charAt(j)-'a'] == 0){
                    ch_arr[str.charAt(j)-'a'] = 1;
                    l++;
                    while (l > k){
                        if(ch_arr[str.charAt(i)-'a'] == 1){
                            l--;
                        }
                        ch_arr[str.charAt(i)-'a']--;
                        i++;
                    }
                } else {
                    ch_arr[str.charAt(j)-'a']++;
                }
                j++;
            }
            if(max < (j-i)){
                max = (j-i);
                subString = str.substring(i, j);
            }
        }
        System.out.println(subString);
    }
}
