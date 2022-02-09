package com.geekcircle.Flipkart;

import java.util.Arrays;

public class A1_MinimumJumpToReachEnd {

    public static void main(String[] args) {
        int[] arr = {3, 3, 0, 2, 1, 2, 4, 2, 0, 0};
        System.out.println(monkeyJump(arr) +1 );
    }

    private static int monkeyJump(int[] arr){
        int[] lookup = new int[arr.length];
        lookup[0] = 0;
        int n = arr.length;
        int i = 0;
        while (i != n ){
            int j = i-1;
            while (j >= 0){
                if(arr[j] >= (i-j)){
                    if(lookup[i] > (lookup[j]+1) || lookup[i] == 0){
                        if(lookup[i] == 0){
                            lookup[i] = lookup[j]+1;
                        } else {
                            lookup[i] = Math.min(lookup[i], lookup[j]+1);
                        }
                    }
                }
                j--;
            }
            i++;
        }
        System.out.println(Arrays.toString(lookup));
        return lookup[n-1];
    }

}
