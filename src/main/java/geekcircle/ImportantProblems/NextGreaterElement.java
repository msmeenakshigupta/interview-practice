package com.geekcircle.ImportantProblems;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {4,5,2,25};
        System.out.println(Arrays.toString(NGENaive(arr)));
        System.out.println(Arrays.toString(NGEOptimized(arr)));
    }

    private static int[] NGENaive(int[] arr){
        System.out.println("Naive :");
        int length = arr.length;
        int[] result = new int[length];
        result[length-1] = -1;
        for(int i = 0; i < length-1; i++){
            for(int j = i+1; j < length; j++){
                if(arr[i] < arr[j]){
                    result[i] = j;
                    break;
                }
            }
        }
        return result;
    }

    public static int[] NGEOptimized(int[] arr){
        System.out.println("Optimize :");
        int length = arr.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        result[length-1] = -1;
        for(int i = 1; i < length; i++){
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                result[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
