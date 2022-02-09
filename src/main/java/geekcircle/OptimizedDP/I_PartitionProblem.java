package com.geekcircle.OptimizedDP;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-22
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/


public class I_PartitionProblem {
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        int partitions = 2;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        int part = (int)sum/partitions;
        partitionIntoTwoTabular(arr, part);
        //partitionIntoTwoTree(arr, arr.length-1, part, "");
        /*int[] kPart = new int[partitions];
        for(int i = 0; i < kPart.length-1; i++){
            kPart[i] = part;
        }
        kPart[kPart.length-1] = sum - (part * (partitions-1));
        for(int i = 0; i < kPart.length; i++){
            partitionIntoTwoTree(arr, );
        }*/
    }

    private static void partitionIntoTwoTree(int[] arr, int n, int sum, String string){
        if(sum == 0){
            System.out.println(string);
            return;
        }

        if(n < 0){
            return;
        }

        if((sum - arr[n]) >= 0){
            partitionIntoTwoTree(arr, n-1,sum - arr[n], string + " " + arr[n]);
        }
        partitionIntoTwoTree(arr, n-1, sum, string);

    }

    private static void partitionIntoTwoTabular(int[] arr, int sum){
        int n = arr.length;
        int[][] lookup = new int[n+1][sum+1];
        for(int i = 1; i < n+1;i++){
            for(int j= 1; j < sum+1; j++){
                if(j - arr[i-1] >= 0) {
                    int remaining = j - arr[i-1];
                    lookup[i][j] = lookup[i - 1][remaining] + arr[i-1];
                } else {
                    lookup[i][j] = 0;
                }
            }
        }
        System.out.print("\t");
        for(int j = 0; j < sum + 1; j++){
            System.out.print(j +"\t");
        }
        System.out.println();
        for(int i = 0; i < n+1;i++) {
            if(i != 0){
                System.out.print(arr[i-1] +"\t");
            } else {
                System.out.print("\t");
            }
            for (int j = 0; j < sum + 1; j++) {
                System.out.print(lookup[i][j] +"\t");
            }
            System.out.println();
        }
    }
}
