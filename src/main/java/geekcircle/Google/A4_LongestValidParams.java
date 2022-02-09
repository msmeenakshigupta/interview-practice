package com.geekcircle.Google;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-16
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.Stack;

public class A4_LongestValidParams {
    public static void main(String[] args) {
        String s = "}()()(){()()";
        Stack<Character> stack = new Stack<>();
        int ctr = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < s.length(); i++){
            switch (s.charAt(i)){
                case '{' :
                case '[' :
                case '(' : {
                    stack.push(s.charAt(i));
                    break;
                }
                case '}' : {
                    if(!stack.isEmpty()){
                        if(stack.peek() == '{'){
                            ctr+=2;
                            max = Integer.max(ctr, max);
                            stack.pop();
                        }
                    } else {
                        ctr = 0;
                    }
                    break;
                }
                case ']' : {
                    if(!stack.isEmpty()){
                        if(stack.peek() == '['){
                            ctr+=2;
                            max = Integer.max(ctr, max);
                            stack.pop();
                        }
                    } else {
                        ctr = 0;
                    }
                    break;
                }
                case ')' : {
                    if(!stack.isEmpty()){
                        if(stack.peek() == '('){
                            ctr+=2;
                            max = Integer.max(ctr, max);
                            stack.pop();
                        }
                    } else {
                        ctr = 0;
                    }
                    break;
                }
            }
        }
        System.out.println(max);
    }
}
