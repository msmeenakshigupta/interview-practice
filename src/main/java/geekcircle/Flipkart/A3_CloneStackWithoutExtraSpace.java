package com.geekcircle.Flipkart;

import java.util.Arrays;
import java.util.Stack;

public class A3_CloneStackWithoutExtraSpace {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        Stack<Integer> clone = new Stack<>();
        cloneStack(stack, clone);
        System.out.println(clone);
    }

    private static void cloneStack(Stack<Integer> orgStack, Stack<Integer> clone){
        if(orgStack.empty()){
            return;
        }
        Integer current = orgStack.pop();
        cloneStack(orgStack, clone);
        orgStack.push(current);
        clone.add(current);
    }
}
