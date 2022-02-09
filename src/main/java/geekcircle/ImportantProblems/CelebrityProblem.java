package com.geekcircle.ImportantProblems;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-13
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.ArrayList;
import java.util.List;

public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] arr =   {
                            {0,0,1,0},
                            {0,0,1,0},
                            {0,0,0,0},
                            {0,0,1,0}
                        };
        System.out.println(whoIsCelebritySol2(arr));
    }

    private static int whoIsCelebritySol1(int[][] arr){
        return 0;
    }

    private static int whoIsCelebritySol2(int[][] arr){
        List<Integer> list = new ArrayList<>();
        for(int i= 0; i < arr.length; i++){
            list.add(i);
        }
        int a = list.get(0);
        int b = 0;
        for(int i = 1; i < list.size(); i++){
            b = list.get(i);
            if(knows(arr, a, b)){
                a = b;
            }
        }
        return b;
    }

    private static int whoIsCelebritySol3(int[][] arr){
        return 0;
    }

    private static boolean knows(int[][] arr, int a, int b){
        if(arr[a][b] == 1){
            return true;
        }
        return false;
    }

}
