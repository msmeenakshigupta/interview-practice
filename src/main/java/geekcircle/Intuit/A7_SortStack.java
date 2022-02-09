package com.geekcircle.Intuit;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-25
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.Stack;

public class A7_SortStack {
    public static void main(String[] args) {
        int[] arr = {11,2,32,3,41};
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> sortedStack = new Stack<>();
        for (int i : arr){
            stack.push(i);
        }
        System.out.println("Current Stack "+ stack);
        while (!stack.isEmpty()){
            Integer cur = stack.pop();
            while (!sortedStack.isEmpty() && sortedStack.peek() < cur){
                stack.push(sortedStack.pop());
            }
            sortedStack.push(cur);
        }
        System.out.println("Sorted Stack "+ sortedStack);
    }
}
