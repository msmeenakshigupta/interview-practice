package com.geekcircle.Flipkart;

import java.util.Stack;

public class A4_ReverseStackWithoutExtraSpace {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        reverseStack(stack);
        System.out.println(stack.peek());
    }

    public static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        } else {
            Integer current = stack.pop();
            reverseStack(stack);
            addToStack(stack, current);
        }
    }

    private static void addToStack(Stack<Integer> stack, Integer current){
        if(stack.isEmpty()){
            stack.push(current);
        } else {
            Integer i = stack.pop();
            addToStack(stack, current);
            stack.add(i);
        }
    }


}
