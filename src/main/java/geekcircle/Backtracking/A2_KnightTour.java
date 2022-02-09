package com.geekcircle.Backtracking;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-11
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class A2_KnightTour {
    public static void main(String[] args) {
        int N = 6;
        int[][] chess = new int[N][N];
        boolean found = false;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                found = knightTour(chess, i, j, 1, N);
                if(found){
                    break;
                }
            }
            if(found){
                break;
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(chess[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static boolean knightTour(int[][] chess, int r, int c, int num, int N) {
        final int[] row = { 2, 1, -1, -2, -2, -1, 1, 2 };
        final int[] col = { 1, 2, 2, 1, -1, -2, -2, -1};

        boolean found = false;
        if(r < N && r >= 0 && c < N && c >= 0 && chess[r][c] == 0){
            chess[r][c] = num;
            for(int i = 0; i < row.length; i++){
                found = knightTour(chess, r+row[i], c+col[i], num+1, N);
                if(found){
                    System.out.println("Num: "+num+" it: "+i);
                    break;
                }
            }
            if(!found && num != N*N){
                chess[r][c] = 0;
            }
            if(!found && num == N*N){
                found = true;
            }
        }

        return found;
    }
}
