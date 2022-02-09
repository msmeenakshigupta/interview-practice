package com.geekcircle.Top100;

import com.geekcircle.Utility;

public class A97_WildCardPatternMatching {
    public static void main(String[] args) {
        String str = "xyxzzxy";
        String pattern = "x*?y";
        //System.out.println(wildCardPatternMatching(str, pattern, str.length()-1, pattern.length()-1, ""));
        System.out.println(wildCardPatternMatchingOptimized(str, pattern));
    }

    private static boolean wildCardPatternMatching(String str, String pattern, int i, int k, String string){
        if(i == k && i < 0){
            System.out.println(string);
            return true;
        }

        if(i < 0 || k < 0){
            return false;
        }

        if(pattern.charAt(k) == '?'){
            return wildCardPatternMatching(str, pattern, i-1, k-1, str.charAt(i)+string);
        } else if(pattern.charAt(k) == '*') {
            return (wildCardPatternMatching(str, pattern, i-1, k, str.charAt(i)+string) || wildCardPatternMatching(str, pattern, i-1, k-1, str.charAt(i)+string));
        } else {
            if(pattern.charAt(k) == str.charAt(i)){
                return wildCardPatternMatching(str, pattern, i-1, k-1, str.charAt(i)+string);
            } else {
                return false;
            }
        }
    }

    private static boolean wildCardPatternMatchingOptimized(String word, String pattern){
        Boolean[][] lookup = new Boolean[pattern.length()+1][word.length()+1];
        for(int i = 0; i < lookup.length; i++){
            for (int j = 0; j <lookup[0].length; j++){
                lookup[i][j] = false;
            }
        }
        lookup[0][0] = true;
        for(int i = 1; i < lookup.length; i++){
            for(int j = 1; j < lookup[0].length; j++) {
                if(pattern.charAt(i-1) == '*'){
                    lookup[i][j] = lookup[i-1][j-1] || lookup[i][j-1];
                } else if(pattern.charAt(i-1) == '?'){
                    lookup[i][j] = lookup[i-1][j-1];
                } else {
                    if(pattern.charAt(i-1) == word.charAt(j-1)){
                        lookup[i][j] = lookup[i - 1][j - 1];
                    } else {
                        lookup[i][j] = false;
                    }
                }
            }
        }
        Character[] patternC = new Character[pattern.length()];
        Character[] wordC = new Character[word.length()];
        for(int i = 0; i < patternC.length; i++) {
            patternC[i] = pattern.charAt(i);
        }
        for(int i = 0; i < wordC.length; i++) {
            wordC[i] = word.charAt(i);
        }
        Utility<Boolean, Character, Character> utility = new Utility<>(Boolean.class);
        utility.printMatrix(lookup, patternC, wordC);
        return lookup[pattern.length()][word.length()];
    }
}
