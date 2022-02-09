package com.geekcircle.ImportantProblems;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleUnderHistogram {
    public static void main(String[] args) {
        int[] arr = {4,2};
        System.out.println(largestRectangleUnderHistogramOptimized(arr));
    }

    private static int largestRectangleUnderHistogramNaive(int[] arr){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int left = i-1;
            int right = i+1;
            while (left >= 0 && arr[i] <= arr[left]){
                left--;
            }
            while (right < n && arr[i] <= arr[right]){
                right++;
            }
            int d = (right - left - 1) * arr[i];
            if(d > max){
                max = d;
            }
        }
        return max;
    }

    private static int largestRectangleUnderHistogramOptimized(int[] arr){
        int length = arr.length;
        int[] leftToRightNextSmallestIndex = nextSmallestIndex(arr,"leftToRight");
        int[] rightToLeftNextSmallestIndex = nextSmallestIndex(arr, "rightToLeft");
        /*System.out.println(Arrays.toString(leftToRightNextSmallestIndex));
        System.out.println(Arrays.toString(rightToLeftNextSmallestIndex));*/
        int max = 0;
        for(int i = 0; i < length; i++){
            int cal = (leftToRightNextSmallestIndex[i] - rightToLeftNextSmallestIndex[i] -1 ) * arr[i];
            if(cal > max){
                max = cal;
            }
        }
        return max;
    }

    private static int[] nextSmallestIndex(int[] arr, String way){
        Stack<Integer> stack = new Stack<>();
        int length = arr.length;
        int[] result = new int[length];
        switch (way){
            case "leftToRight" : {
                //result[length-1] = length;
                stack.push(0);
                for(int i = 0; i < length; i++){
                    while (!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                        result[stack.peek()] = i;
                        stack.pop();
                    }
                    stack.push(i);
                }
                while (!stack.isEmpty()){
                    result[stack.peek()] = length;
                    stack.pop();
                }
                break;
            }
            case "rightToLeft" : {
                //result[0] = -1;
                stack.push(length-1);
                for(int i = length-1; i >= 0; i--){
                    while (!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                        result[stack.peek()] = i;
                        stack.pop();
                    }
                    stack.push(i);
                }
                while (!stack.isEmpty()){
                    result[stack.pop()] = -1;
                }
            }
        }
        return result;
    }
}
