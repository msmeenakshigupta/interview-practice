package com.geekcircle.Stack;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-26
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String string = "(a+b)";
        for(int i = 0; i < string.length(); i++){
            Character ch = string.charAt(i);
            switch (ch){
                case '(' :
                case '{' :
                case '[' :
                    stack.push(ch);
                    break;
                case ')' :
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    } else {
                        System.out.println("Invalid");
                        return;
                    }
                    break;
                case '}' :
                    if(!stack.isEmpty() && stack.peek() == '{'){
                        stack.pop();
                    } else {
                        System.out.println("Invalid");
                        return;
                    }
                    break;
                case ']' :
                    if(!stack.isEmpty() && stack.peek() == '['){
                        stack.pop();
                    } else {
                        System.out.println("Invalid");
                        return;
                    }
                    break;
            }
        }
        if(!stack.isEmpty()){
            System.out.println("Invalid");
            return;
        }
        System.out.println("Valid");
    }
}
