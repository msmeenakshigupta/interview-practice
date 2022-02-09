package com.geekcircle.ImportantProblems;

public class SearchElementInSortedMatrix {
    public static void main(String[] args) {
        int[][] arr = { {1, 5, 9},
                        {14, 20, 21},
                        {30, 34, 43}
        };
        int k = 14;
        searchInSortedMatrix(arr, k);

    }

    private static void searchInSortedMatrix(int[][] arr, int k){
        int n = arr.length;
        int i = 0;
        int j = n-1;
        while (i >= 0 && j < n){
            if(k == arr[i][j]){
                System.out.println("Found "+i+","+j);
                break;
            } else if(k > arr[i][j]){
                i++;
            } else {
                j--;
            }
        }
    }
}
