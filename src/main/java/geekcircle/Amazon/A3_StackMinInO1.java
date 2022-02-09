package com.geekcircle.Amazon;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-17
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.Stack;

public class A3_StackMinInO1 {
    public static void main(String[] args) {
        int[] arr = {18,19,29,15,16};
        Stack<Integer> main = new Stack<>();
        Stack<Integer> min = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            main.push(arr[i]);
            if(min.isEmpty() || min.peek() > arr[i]){
                min.push(arr[i]);
            }
        }
        for(int i = 0; i < arr.length; i++){
            int poped = main.pop();
            System.out.println("Item:" + poped + " Min:" + min.peek());
            if(poped == min.peek()){
                min.pop();
            }
        }
    }
}
