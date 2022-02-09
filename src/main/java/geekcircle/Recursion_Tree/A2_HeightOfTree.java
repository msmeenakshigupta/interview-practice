package com.geekcircle.Recursion_Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-02
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

import java.util.Stack;

public class A2_HeightOfTree {
    public static void main(String[] args) {
        /*
                        1
                       / \
                      2  3
                     /  /\
                    4  5 6
             */

        TreeNode root = new TreeNode(1,new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5, new TreeNode(7), null), new TreeNode(6)));
        System.out.println(heightRecursive(root));
        System.out.println(heightIterative(root));
    }

    private static int heightRecursive(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = heightRecursive(root.left);
        int right = heightRecursive(root.right);

        return left > right ? left + 1 : right + 1;
    }

    private static int heightIterative(TreeNode root){
        if(root == null) {
            return 0;
        }
        Stack<TreeNode> currentStack = new Stack<>();
        Stack<TreeNode> nextStack = new Stack<>();
        currentStack.push(root);
        int height = 1;
        while (!currentStack.isEmpty()){
            TreeNode node = currentStack.pop();
            System.out.println("#" + height + " "+ node.val);
            if(node.left != null){
                nextStack.push(node.left);
            }
            if(node.right != null){
                nextStack.push(node.right);
            }

            if(currentStack.isEmpty() && !nextStack.isEmpty()){
                currentStack = nextStack;
                nextStack = new Stack<>();
                height++;
            }
        }
        return height;
    }
}
