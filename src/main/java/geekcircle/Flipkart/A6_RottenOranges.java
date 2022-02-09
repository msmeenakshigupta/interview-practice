package com.geekcircle.Flipkart;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int r;
    int c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class A6_RottenOranges {
    public static void main(String[] args) {
        int arr[][] = { {2, 1, 0, 2, 1},
                        {1, 0, 1, 2, 1},
                        {1, 0, 0, 2, 1}};
        System.out.println(rottenOranges(arr));

    }

    private static int rottenOranges(int[][] arr){
        int[][] possibility =   {
                                    {-1, 0, +1, 0},
                                    {0, +1, 0, -1}
                                };
        Queue<Pair> queue = new LinkedList<>();
        int ctr = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j] == 2){
                    queue.add(new Pair(i,j));
                }
            }
        }

        Queue<Pair> nextQueue = new LinkedList<>();
        while (!queue.isEmpty()){
            Pair current = queue.poll();
            for(int k = 0; k < possibility[0].length; k++){
                if(current.r+possibility[0][k] < arr.length && current.r+possibility[0][k] >= 0
                        && current.c+possibility[1][k] >= 0 && current.c+possibility[1][k] < arr[0].length
                        && arr[current.r+possibility[0][k]][current.c+possibility[1][k]] == 1) {
                    arr[current.r+possibility[0][k]][current.c+possibility[1][k]] = 2;
                    nextQueue.add(new Pair(current.r+possibility[0][k], current.c+possibility[1][k]));
                }
            }
            if(queue.isEmpty() && !nextQueue.isEmpty()){
                printMatrix(arr);
                ctr++;
                queue = nextQueue;
                nextQueue = new LinkedList<>();
            }
        }

        return ctr;
    }

    private static void printMatrix(int[][] arr){
        System.out.println();
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
