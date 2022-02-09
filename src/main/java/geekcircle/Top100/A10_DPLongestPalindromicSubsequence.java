package com.geekcircle.Top100;

public class A10_DPLongestPalindromicSubsequence {
    public static void main(String[] args) {
        String str = "ARDDCACB";
        //System.out.println(longestPalindromicSubSequenceTree(str, 0, str.length()-1, "", 0));
        System.out.println(longestPalindromicSubSequenceMatrix(str));
    }

    private static int longestPalindromicSubSequenceTree(String str, int i, int j, String s, int n){
        if(j < i){
            return 0;
        }

        int include = 0;
        if(str.charAt(i) == str.charAt(j)){
            int num = 2;
            if(i == j){
                num = 1;
            }
            include = num + longestPalindromicSubSequenceTree(str, i+1, j-1, s+str.charAt(i), n+num);
        }
        int exclude = Integer.max(longestPalindromicSubSequenceTree(str, i+1, j, s, n), longestPalindromicSubSequenceTree(str, i, j-1, s, n));
        return Integer.max(include, exclude);
    }

    private static int longestPalindromicSubSequenceMatrix(String string){
        int n = string.length();
        int[][] lookup = new int[n+1][n+1];
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < n+1; j++){
                int m = Integer.max(lookup[i-1][j], lookup[i][j-1]);
                if(string.charAt(n-i) == string.charAt(j-1)){
                    lookup[i][j] = Integer.max(lookup[i-1][j-1]+1, m);
                } else {
                    lookup[i][j] = m;
                }
                System.out.print(lookup[i][j]+" ");
            }
            System.out.println();
        }
        return 0;
    }
}
