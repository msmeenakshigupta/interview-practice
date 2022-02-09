package com.geekcircle.Recursion_Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-03
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

import java.util.Stack;

public class A5_SpiralZigZagOrderTraversal {
    public static void main(String[] args) {
            /*
                        1
                       / \
                      2  3
                     /  /\
                    4  5 6
             */

        TreeNode root = new TreeNode(1,new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5), new TreeNode(6)));
        spiralOrderTraversal(root);
    }

    private static void spiralOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> currentStack = new Stack<>();
        Stack<TreeNode> nextStack = new Stack<>();
        boolean leftToRight = true;
        currentStack.push(root);
        while (!currentStack.isEmpty()){
            TreeNode node = currentStack.pop();
            System.out.println(node.val);
            if(leftToRight){
                if(node.left != null){
                    nextStack.push(node.left);
                }
                if(node.right != null){
                    nextStack.push(node.right);
                }
            } else {
                if(node.right != null){
                    nextStack.push(node.right);
                }
                if(node.left != null){
                    nextStack.push(node.left);
                }
            }
            if(currentStack.isEmpty()){
                currentStack = nextStack;
                nextStack = new Stack<>();
                leftToRight = !leftToRight;
            }
        }
    }
}
