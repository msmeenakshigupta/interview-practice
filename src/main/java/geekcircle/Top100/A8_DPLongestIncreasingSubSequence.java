package com.geekcircle.Top100;

public class A8_DPLongestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        //System.out.println(longestIncreasingSubsequence(arr, 0, arr.length-1, Integer.MIN_VALUE, "", 0));
        System.out.println(longestIncreasingSubSequenceOptimize(arr));

    }

    //O(n^n) // 5^5 256, 3125, 46656
    private static int longestIncreasingSubsequence(int[] arr, int i, int n, int last, String str, int ctr){
        if(i == n){
            return ctr;
        }

        int include = 0;
        if(last < arr[i]){
            include = longestIncreasingSubsequence(arr, i+1,n, arr[i], str+" "+arr[i], ctr+1);
        }
        int exclude = longestIncreasingSubsequence(arr, i+1,n, last, str, ctr);
        return Integer.max(include, exclude);
    }

    //O(n^2) // 4*4 = 16, 25, 36
    private static int longestIncreasingSubSequenceOptimize(int[] arr){
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            result[i] = 1;
        }
        int j = 0;
        int i = 1;
        int max = 0;
        while (i < arr.length){
            if(arr[j] < arr[i]){
                if(result[j] + 1 > result[i]){
                    result[i] = result[j]+1;
                    if(max < result[i]){
                        max = result[i];
                    }
                }
            }
            j++;
            if(i == j){
                j = 0;
                i++;
            }
        }
        return max;
    }
}
