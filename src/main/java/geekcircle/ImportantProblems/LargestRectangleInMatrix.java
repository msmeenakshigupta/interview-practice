package com.geekcircle.ImportantProblems;

import java.util.Arrays;

public class LargestRectangleInMatrix {
    public static void main(String[] args) {
//        int[][] matrix = {
//                            {0,1,1,1,1},
//                            {1,1,0,1,1},
//                            {1,1,0,1,1,},
//                            {0,1,0,0,0}
//                         };

        int[][] matrix = {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
        int[] arr = new int[matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    arr[j] = 0;
                } else {
                    arr[j] = arr[j] + 1;
                }
            }
            max = Integer.max(largestRectangleUnderHistogramNaive(arr), max);
        }
        System.out.println(max);
    }

    private static int largestRectangleUnderHistogramNaive(int[] arr){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int left = i-1;
            int right = i+1;
            while (left >= 0 && arr[i] <= arr[left]){
                left--;
            }
            while (right < n && arr[i] <= arr[right]){
                right++;
            }
            int d = (right - left - 1) * arr[i];
            if(d > max){
                max = d;
            }
        }
        return max;
    }
}
