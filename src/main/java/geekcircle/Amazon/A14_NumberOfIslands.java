package com.geekcircle.Amazon;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-18
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class A14_NumberOfIslands {
    public static void main(String[] args) {
        int[][] arr = {{1,1,0},{0,0,1},{1,0,1}};
        System.out.println(numberOfIslands(arr));
    }

    private static int numberOfIslands(int[][] arr){
        int island = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i][j] == 1){
                    island++;
                    fillIsland(arr, i, j);
                }
            }
        }
        return island;
    }

    private static void fillIsland(int[][] arr, int x, int y){
        int[] row = {-1,0,1,0,-1,1,1,-1};
        int[] col = {0,1,0,-1,1,1,-1,-1};
        arr[x][y] = 2;
        for(int i = 0; i < row.length; i++){
            if(x+row[i] < arr.length && x+row[i] >= 0 && y+col[i] < arr.length && y+col[i] >= 0 && arr[x+row[i]][y+col[i]] == 1){
                fillIsland(arr, x+row[i], y+col[i]);
            }
        }
    }
}
