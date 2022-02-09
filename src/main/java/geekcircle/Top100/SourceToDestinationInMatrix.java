package com.geekcircle.Top100;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-31
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.HashMap;
import java.util.Map;

public class SourceToDestinationInMatrix {

    static int iteration = 0;
    public static void main(String[] args) {
        int[][] matrix =
                {
                        { 4, 4, 6, 5, 5, 1, 1, 1, 7, 4 },
                        { 3, 6, 2, 4, 6, 5, 7, 2, 6, 6 },
                        { 1, 3, 6, 1, 1, 1, 7, 1, 4, 5 },
                        { 7, 5, 6, 3, 1, 3, 3, 1, 1, 7 },
                        { 3, 4, 6, 4, 7, 2, 6, 5, 4, 4 },
                        { 3, 2, 5, 1, 2, 5, 1, 2, 3, 4 },
                        { 4, 2, 2, 2, 5, 2, 3, 7, 7, 3 },
                        { 7, 2, 4, 3, 5, 2, 2, 3, 6, 3 },
                        { 5, 1, 4, 2, 6, 4, 6, 7, 3, 7 },
                        { 1, 4, 1, 7, 5, 3, 6, 5, 3, 4 }
                };

        Map<String, Boolean> lookup = new HashMap<>();
        System.out.println(path(matrix, 0,0, 1, lookup));
        System.out.println("Iterations "+iteration);
    }


    static boolean path(int[][] matrix, int row, int col, int dest, Map<String, Boolean> lookup){
        iteration++;
        if(matrix[row][col] == dest){
            return true;
        }

        if(row == matrix.length-1 || col == matrix[0].length-1){
            return false;
        }
        boolean rowPath = false, colPath = false;
        if(row < matrix.length){
            String key = (row+1)+"|"+col;
            if(!lookup.containsKey(key)){
                rowPath = path(matrix, row+1, col, dest, lookup);
                lookup.put(key, rowPath);
                if(rowPath){
                    System.out.println(matrix[row+1][col]);
                }
            } else {
                rowPath = lookup.get(key);
            }
        }
        if(col < matrix[0].length){
            String key = row+"|"+(col+1);
            if(!lookup.containsKey(key)){
                colPath = path(matrix, row, col+1, dest, lookup);
                if(colPath){
                    System.out.println(matrix[row][col+1]);
                }
                lookup.put(key, colPath);
            } else {
                colPath = lookup.get(key);
            }

        }

        return rowPath || colPath;

    }
}
