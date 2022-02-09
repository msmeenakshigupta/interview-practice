package com.geekcircle.Intuit;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-24
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class A2_SortRunningStream {
    public static void main(String[] args) {
        int[] arr = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
        int n = arr.length;
        for(int i = 1; i < n; i++){
            int j = 0;
            while(j < i && arr[j] < arr[i]){
                j++;
            }
            int t = arr[i];
            int k = i;
            while (k > j){
                arr[k] = arr[k-1];
                k--;
            }
            arr[j] = t;
            for(j = 0; j <= i; j++){
                System.out.print(arr[j]+" ");
            }
            System.out.println("Medium : " + medium(arr, 0, i));
        }
    }

    //Medium means middle value after sort, or mid value average in case of even
    private static double medium(int[] arr, int i, int j){
        int n = j - i + 1;
        if(n % 2 == 0){
            int m = ((n)/2)-1;
            return (arr[m]+arr[m+1])/2.0;
        } else {
            return arr[((n)/2)];
        }
    }
}
