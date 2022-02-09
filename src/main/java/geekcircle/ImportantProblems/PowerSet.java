package com.geekcircle.ImportantProblems;

public class PowerSet {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        printPowerSet(arr, 0, arr.length, "");
    }

    private static void printPowerSet(int[] arr, int i, int n, String str){
        if(i == n){
            System.out.print("{"+str+"}, ");
            return;
        }

        printPowerSet(arr, i+1, n, str);
        printPowerSet(arr, i+1, n, str+arr[i]);
    }
}
