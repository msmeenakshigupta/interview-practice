package com.geekcircle.Top100;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-04
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class A58_NQueueProblem {

    //Most Common Approach
    public static void main(String[] args) {
        int N = 8;
        int[][] arr = new int[N][N];
        nQueueProblem(arr, 0);
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static boolean nQueueProblem(int[][] arr, int row){
        if (row >= arr.length){
            return true;
        }

        for (int i = 0; i < arr.length; i++) {
            if (isSafe(arr, row, i)) {
                System.out.println("Placed ["+row+","+i+"]");
                arr[row][i] = 1;

                if (nQueueProblem(arr, row + 1))
                    return true;

                arr[row][i] = 0;
            }
        }

        return false;
    }

    private static boolean isSafe(int[][] arr, int row, int col){
        int i, j;

        for (i = 0; i < row; i++)
            if (arr[i][col] == 1)
                return false;

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (arr[i][j] == 1)
                return false;

        for (i = row, j = col; j >= 0 && i < arr.length; i++, j--)
            if (arr[i][j] == 1)
                return false;

        return true;
    }
}
