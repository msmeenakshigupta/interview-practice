package com.geekcircle.Matrix;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-06
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A5_RottenOranges {
    public static void main(String[] args) {
        int arr[][] = { {2, 1, 0, 2, 1},
                        {1, 0, 1, 2, 1},
                        {1, 0, 0, 2, 1}
                        };
        System.out.println(rottenOrange(arr));

    }

    private static int rottenOrange(int arr[][]){
        int ctr = 0;
        while (true){
            List<Integer> row = new ArrayList<>();
            List<Integer> col = new ArrayList<>();
            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < arr[i].length;j++){
                    if(arr[i][j] == 2){
                        row.add(i);
                        col.add(j);
                    }
                }
            }

            int[] r = {0,-1,0,1};
            int[] c = {-1,0,1,0};

            boolean found = false;
            for(int i = 0; i < row.size(); i++){
                arr[row.get(i)][col.get(i)] = 0;
                for(int j = 0; j < r.length; j++){
                    int newRow = row.get(i) + r[j];
                    int newCol = (col.get(i) + c[j]);
                    if(newRow < arr.length && newRow >= 0 && newCol < arr[0].length && newCol >= 0 && arr[newRow][newCol] == 1){
                        arr[newRow][newCol] = 2;
                        found = true;
                    }
                }
            }
            if(found){
                ctr++;
            } else {
                return ctr;
            }

            for(int i = 0; i < arr.length; i++){
                System.out.println(Arrays.toString(arr[i]));
            }
            System.out.println();
        }

    }

}
