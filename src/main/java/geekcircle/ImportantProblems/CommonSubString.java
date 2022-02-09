package com.geekcircle.ImportantProblems;

public class CommonSubString {
    public static void main(String[] args) {
        String str1 = "AASHANKARFF";
        String str2 = "AKSHANKARABC";
        //System.out.println(maximumCommonSubStringTree(str1, str2, str1.length()-1, str2.length()-1, "", false, 0));
        System.out.println(maximumCommonSubStringMatrix(str1, str2));
    }

    private static int maximumCommonSubStringTree(String str1, String str2, int i, int j, String str, boolean lastConsider, int n){
        if(i < 0 || j < 0 ){
            return 0;
        }
        int include = 0;
        int exclude = 0;
        if(str1.charAt(i) == str2.charAt(j)){
            if(lastConsider){
                include = maximumCommonSubStringTree(str1, str2, i-1, j-1, str1.charAt(i)+str, true, n+1);
            } else {
                include = maximumCommonSubStringTree(str1, str2, i-1, j-1, str1.charAt(i)+"", true, 1);
            }
        } else {
            if(lastConsider){
                include = n;
            }
            exclude = Integer.max(maximumCommonSubStringTree(str1, str2, i-1, j, "", false, 0), maximumCommonSubStringTree(str1, str2, i, j-1, "", false, 0));
        }
        return Integer.max(include, exclude);
    }

    //O(m*n)
    private static int maximumCommonSubStringMatrix(String str1, String str2){
        int[][] lookup = new int[str1.length()+1][str2.length()+1];
        int max = 0;
        for(int i = 1; i < str1.length(); i++){
            for(int j = 1; j < str2.length(); j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    if(lookup[i-1][j-1] != 0){
                        lookup[i][j] = lookup[i-1][j-1] + 1;
                        if(lookup[i][j] > max){
                            max = lookup[i][j];
                        }
                    } else {
                        lookup[i][j] = 1;
                    }
                }
            }
        }
        return max;
    }
}
