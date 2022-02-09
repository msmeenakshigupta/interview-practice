package com.geekcircle.Backtracking;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-12
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

//Self Solution
public class A3_ShortestPathMaze {
    public static void main(String[] args) {
        int M = 8, N = 8;
        int[][] maze = {
                { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
                { 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
                { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
                { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                { 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
        };
        mazePath(maze, 0,0, 7,5,"", 0);
    }

    static int min = Integer.MAX_VALUE;
    private static void mazePath(int[][] maze, int r, int c, int dr, int dc, String str, int num){
        if(r > maze.length-1 || c > maze[0].length-1){
            return;
        }

        if(r == dr && c == dc){
            str = str + " ("+r+","+c+")";
            min = Integer.min(num, min);
            if(num == min){
                System.out.println(num);
                System.out.println(str);
            }
            return;
        }

        final int[] row = {-1,0,1, 0};
        final int[] col = { 0,1,0,-1};

        for(int i = 0; i < row.length; i++){
            if(r+row[i] < maze.length && r+row[i] >= 0 && c+col[i] < maze[0].length && c+col[i] >= 0 && maze[r+row[i]][c+col[i]] == 1){
                maze[r][c] = 0; //Mark Not Allowed
                mazePath(maze, r+row[i], c+col[i], dr, dc, str + " ("+r+","+c+")", num+1);
                maze[r][c] = 1; //Mark Not Allowed
            }
        }
    }
}
