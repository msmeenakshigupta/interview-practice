package com.geekcircle.Flipkart;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class A10_AlienDictionary {
    public static void main(String[] args) {
        String[] arr = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(alienDictionary(arr));
    }

    private static String alienDictionary(String[] arr){
        Set<Character> set = new LinkedHashSet<>();
        int j = 0;
        while (true) {
            boolean found = false;
            for(int i = 0; i < arr.length; i++){
                if(j < arr[i].length()){
                    if(!set.contains(arr[i].charAt(j))){
                        set.add(arr[i].charAt(j));
                    }
                    found = true;
                }

            }
            if(!found){
                break;
            }
            j++;
        }
        return set.toString();
    }
}
