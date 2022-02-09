package com.geekcircle.Amazon;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-17
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.Stack;

public class A7_NextLargest {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4};
        nextLargestSol2(arr);
    }

    private static void nextLargestSol1(int[] arr){
        for(int i = 0; i < arr.length; i++){
            boolean found = false;
            for(int j = i+1;j < arr.length; j++){
                if(arr[i] < arr[j]){
                    found = true;
                    System.out.print(arr[j]+" ");
                    break;
                }
            }
            if(!found){
                System.out.print(-1+" ");
            }
        }
    }

    //Memorizing
    private static void nextLargestSol2(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < arr.length){
            while (!stack.isEmpty()){
                if(arr[i] > stack.peek()){
                    stack.pop();
                    System.out.println(arr[i]);
                } else {
                    break;
                }
            }
            stack.push(arr[i++]);
        }
    }
}