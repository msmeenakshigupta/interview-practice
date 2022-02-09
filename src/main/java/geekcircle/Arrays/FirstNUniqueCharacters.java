package com.geekcircle.Arrays;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-27
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNUniqueCharacters {

    public static void main(String[] args) {
        String s = "leetcode";
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), -1);
            } else {
                map.put(s.charAt(i), i);
            }
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() >= 0){
                System.out.println(entry.getValue());
            }
        }
    }

}
