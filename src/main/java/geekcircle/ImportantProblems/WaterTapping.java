package com.geekcircle.ImportantProblems;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-09
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class WaterTapping {
    public static void main(String[] args) {
        int[] arr = {7, 0, 4, 2, 5, 0, 6, 4, 0, 5};
        System.out.println("App1 Water Tap : "+ waterTappingApproach1(arr));
        System.out.println("App2 Water Tap : "+ waterTappingApproach2(arr));
        System.out.println("App3 Water Tap : "+ waterTappingApproach3(arr));
        System.out.println("App4 Water Tap : "+ waterTappingApproach4(arr));
    }

    //Brute Force O(n^2)
    private static int waterTappingApproach1(int[] arr){
        int n = arr.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            int leftMax = 0;
            for(int j = i - 1; j >=0; j--){
                if(leftMax < (arr[j])){
                    leftMax = arr[j];
                }
            }

            int rightMax = 0;
            for(int j = i+1; j < n; j++){
                if(rightMax < (arr[j])){
                    rightMax = arr[j];
                }
            }

            int t = Integer.min(leftMax, rightMax) - arr[i];
            t = (t) > 0 ? t : 0 ;
            sum += t;
        }
        return sum;
    }

    //Optimized Approach (O(n) + O(2n))
    private static int waterTappingApproach2(int[] arr){
        int n = arr.length;
        int sum = 0;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = arr[0];
        right[n-1] = arr[n-1];
        for(int i = 1; i < n; i++){
            if(left[i-1] < arr[i]){
                left[i] = arr[i];
            } else {
                left[i] = left[i-1];
            }

            if(right[n-i] < arr[n-i-1]){
                right[n-i-1] = arr[n-i-1];
            } else {
                right[n-i-1] = right[n-i];
            }
        }

        for(int i = 0; i < n; i++){
            sum += Integer.min(left[i],right[i]) - arr[i];
        }
        return sum;
    }

    //Optimized Approach (O(n) + O(n))
    private static int waterTappingApproach3(int[] arr){
        int n = arr.length;
        int sum = 0;
        int right[] = new int[n];
        right[n-1] = arr[n-1];
        for(int i = 1; i < n; i++){
            if(right[n-i] < arr[n-i-1]){
                right[n-i-1] = arr[n-i-1];
            } else {
                right[n-i-1] = right[n-i];
            }
        }

        int max = arr[0];
        for(int i = 0; i < n; i++){
            if(max < arr[i]){
                max = arr[i];
            }
            sum += Integer.min(max,right[i]) - arr[i];
        }
        return sum;
    }

    //Optimized Approach (O(n) + O(1))
    private static int waterTappingApproach4(int[] arr){
        int n = arr.length;
        int i = 0;
        int j = n-1;
        int leftMax = arr[i];
        int rightMax = arr[j];
        int sum = 0;
        while(i < j){
            if(arr[i] < arr[j]){
                i++;
                leftMax = Integer.max(arr[i], leftMax);
                sum += (leftMax - arr[i]);
            } else {
                j--;
                rightMax = Integer.max(arr[j], rightMax);
                sum += (rightMax - arr[j]);
            }
        }
        return sum;
    }
}
