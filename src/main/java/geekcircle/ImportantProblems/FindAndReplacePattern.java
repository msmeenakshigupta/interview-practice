package com.geekcircle.ImportantProblems;

import java.util.*;

public class FindAndReplacePattern {
    public static void main(String[] args) {
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        List<String> strings = new LinkedList<>();
        for(String string : words){
            if(isPatternMatchOptimized(string, pattern)){
                strings.add(string);
            }
        }
        System.out.println(strings);
    }

    private static boolean isPatternMatch(String word, String pattern){
        Map<Character,Character> patternMap = new LinkedHashMap<>();
        for(int i = 0; i < word.length(); i++){
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if(patternMap.containsKey(w)){
                if(patternMap.get(w) != p){
                    return false;
                }
            } else if (patternMap.containsKey(p)) {
                if(patternMap.get(p) != w){
                    return false;
                }
            } else {
                patternMap.put(w,p);
                patternMap.put(p,w);
            }
        }
        return true;
    }

    private static boolean isPatternMatchOptimized(String word, String pattern){
        int[] patternLookup = new int[pattern.length()];
        patternLookup[0] = 1;
        for(int i = 1; i < pattern.length();i++){
            if(pattern.charAt(i-1) == pattern.charAt(i)){
                patternLookup[i] = patternLookup[i-1]+1;
            } else {
                patternLookup[i] = 1;
            }
        }
        int wc = 1;
        for(int i = 1; i < word.length(); i++){
            if(word.charAt(i-1) == word.charAt(i)){
                wc++;
            } else {
                wc = 1;
            }
            if(patternLookup[i] != wc){
                return false;
            }
        }
        return true;
    }
}
