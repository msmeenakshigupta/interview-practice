package com.geekcircle.Top100;

import java.util.*;

public class A20_WordBreakProblem {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>(Arrays.asList(new String[]{"this","th", "is", "famous", "Word", "break", "b","r", "e", "a", "k", "br", "bre", "brek", "ak", "problem"})) ;
        Set<String> lookup = new LinkedHashSet<>(list);
        String str = "Wordbreakproblem";

        wordBreakProblem(lookup, str, 0, 0, "", str.length());

    }
    private static void wordBreakProblem(Set<String> lookup, String str, int i, int j, String result, int count){
        if(i >= str.length() || j >= str.length()){
            /*if(count == 0){*/
                System.out.println(result);
            /*}*/
            return;
        }

        String s =  str.substring(i,j+1);
        if(lookup.contains(s)){
            result = result+" "+s;
            wordBreakProblem(lookup, str.substring(j+1), j+1, j+1, result, count - (j+1-i));
        }
        wordBreakProblem(lookup, str, i, j+1, result, count);
    }
}
