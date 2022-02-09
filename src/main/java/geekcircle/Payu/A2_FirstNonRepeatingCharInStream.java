package com.geekcircle.Payu;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-26
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.LinkedHashMap;
import java.util.Map;

public class A2_FirstNonRepeatingCharInStream {
    public static void main(String[] args) {
        Map<Character, Integer> c = new LinkedHashMap<>();
        String str = "aac";
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++){
            int ctr = 0;
            if(c.containsKey(chars[i])){
                ctr = c.get(chars[i]);
            }
            ctr++;
            c.put(chars[i], ctr);
            boolean found = false;
            for(Map.Entry<Character, Integer> entry : c.entrySet()){
                if(entry.getValue() == 1){
                    found = true;
                    System.out.println(entry.getKey());
                    break;
                }
            }
            if(!found){
                System.out.println("-1");
            }
        }
    }
}
