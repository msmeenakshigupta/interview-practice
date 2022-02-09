package com.geekcircle.Matrix;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-06
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class A4_AllPathInAMatrix {
    public static void main(String[] args) {
        int[][] mat =
                {
                        { 1, 2, 3 },
                        { 4, 5, 6 },
                        { 7, 8, 9 }
                };
        path(mat, 0, 0, mat[0][0]+"");
    }

    private static void path(int[][] mat, int r, int c, String s){
        if(r == mat.length-1 && c == mat[0].length-1){
            System.out.println(s);
            return;
        }
        int row[] = {0, 1};
        int col[] = {1, 0};

        for(int i = 0; i < row.length; i++){
            if(r+row[i] >= 0 && r+row[i] < mat.length && c + col[i] >= 0 && c + col[i] < mat[0].length){
                path(mat, r + row[i], c + col[i], s +" "+mat[r + row[i]][c + col[i]]);
            }
        }
    }
}
