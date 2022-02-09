package com.geekcircle.Top100;

public class A2_DPLongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "ABCBDAB";
        String str2 = "BDCABA";
        //System.out.println(longestCommonSubsequenceTree(str1, str2, str1.length()-1, str2.length()-1,"", 0));
        longestCommonSubsequenceMatrix(str1, str2);
    }

    static int maxTillNow = 0;
    private static int longestCommonSubsequenceTree(String str1, String str2, int i, int j, String str, int n){
        if(i < 0 || j < 0){
            if(n > maxTillNow){
                maxTillNow = n;
                System.out.println(str);
            }
            return 0;
        }
        int include = 0;
        if(str1.charAt(i) == str2.charAt(j)){
            include = 1 + longestCommonSubsequenceTree(str1, str2, i-1, j-1, str1.charAt(i)+str, n+1);
        }
        int exclude = Integer.max(longestCommonSubsequenceTree(str1, str2, i-1, j, str, n), longestCommonSubsequenceTree(str1, str2, i, j-1, str, n));
        return Integer.max(include, exclude);
    }

    private static int longestCommonSubsequenceMatrix(String str1, String str2){
        int[][] lookup = new int[str1.length()+1][str2.length()+1];
        for(int i = 1; i < str1.length(); i++){
            for(int j = 1; j < str2.length(); j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    lookup[i][j] = Integer.max(lookup[i-1][j] + 1, lookup[i][j-1]);
                } else {
                    lookup[i][j] = Integer.max(lookup[i][j-1], lookup[i-1][j]);
                }
            }
        }

        for(int i = 0; i < str1.length(); i++){

            for(int j = 0; j < str2.length(); j++){
                System.out.print(lookup[i][j]+" ");
            }
            System.out.println();
        }
        return 0;
    }
}
