package com.geekcircle.Matrix;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-06
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class A1_FormWordInAMatrix {
    public static void main(String[] args) {
        Character[][] ch = {
                { 'D', 'E', 'M', 'X', 'B' },
                { 'A', 'O', 'E', 'P', 'E' },
                { 'D', 'D', 'C', 'O', 'D' },
                { 'E', 'B', 'E', 'D', 'S' },
                { 'C', 'P', 'Y', 'E', 'N' }
        };

        String word = "CODE";

        for(int i = 0; i < ch.length; i++){
            for(int j = 0; j < ch[0].length; j++){
                if(word.charAt(0) == ch[i][j]){
                    formWord(ch, word.substring(1), i, j, "("+i+","+j+")");
                }
            }
        }
    }


    private static void formWord(Character[][] ch, String word, int r, int c, String path){
        if(word.isEmpty()){
            System.out.println(path);
            return;
        }

        int row[] = { -1, -1, -1,  0, 0,  1, 1, 1 };
        int col[] = { -1,  0,  1, -1, 1, -1, 0, 1 };

        for(int i = 0; i < row.length; i++){
            if(r+row[i] >= 0 && r+row[i] < ch.length && c + col[i] >= 0 && c + col[i] < ch[0].length && ch[r+row[i]][c + col[i]] == word.charAt(0)){
                formWord(ch, word.substring(1), r+row[i], c + col[i],path + ",("+(r+row[i])+","+(c+col[i])+")");
            }
        }
    }

}
