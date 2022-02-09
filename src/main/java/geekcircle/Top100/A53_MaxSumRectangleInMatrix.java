package com.geekcircle.Top100;

import java.util.Arrays;

public class A53_MaxSumRectangleInMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                        {-5,-6,3,1,0},
                        {9,7,8,3,7},
                        {-6,-2,-1,2,-4},
                        {-7,5,5,2,-6},
                        {3,2,9,-5,1}
                    };
        ///maxSumSubArray();
        maxRectangle(arr);
    }

    private static void maxSumSubArray(){
        int[] arr = {-5,9,-6,-7,3};
        int kmaxSoFar = 0;
        int kmaxEndHere =0;
        int tempFrom = 0;
        int from = 0;
        int to = -1;
        for(int k = 0; k < arr.length; k++){
            kmaxEndHere += arr[k];
            if(kmaxSoFar < kmaxEndHere){
                to = k;
                from = tempFrom;
                kmaxSoFar = kmaxEndHere;
            }
            if(kmaxEndHere < 0){
                kmaxEndHere = 0;
                tempFrom = k+1;
            }
        }
        System.out.println("From : "+from+" to: "+to + " Sum: "+kmaxSoFar);
    }

    private static void maxRectangle(int[][] arr){
        int left = 0;
        int right = 0;
        int up = 0;
        int down = 0;
        int maxSoFar = 0;
        int N = arr.length;
        for(int i = 0; i < N; i++){
            int[] lookup = new int[N];
            for(int j = i; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    lookup[k] += arr[k][j];
                }
                System.out.println(Arrays.toString(lookup));
                int maxEndHere =0;
                int from = 0;
                for(int k = 0; k < N; k++){
                    maxEndHere += lookup[k];
                    if(maxSoFar < maxEndHere){
                        maxSoFar = maxEndHere;
                        left = i;
                        right = j;
                        up = from;
                        down = k;
                    }
                    if(maxEndHere < 0){
                        maxEndHere = 0;
                        from = k+1;
                    }
                }
            }
        }
        System.out.println("SUM : "+maxSoFar+" Left: " +left+" Right: "+right+" Up: "+up+" Down: "+down);
    }
}
