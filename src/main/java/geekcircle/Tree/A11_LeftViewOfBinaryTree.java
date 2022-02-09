package com.geekcircle.Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-06
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class A11_LeftViewOfBinaryTree {

    public static void main(String[] args) {
    /*
                        1
                       / \
                      2  3
                     /  /\
                    4  5 6
             */

        TreeNode root = new TreeNode(1,new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5), new TreeNode(6)));
        leftViewOfBinaryTree(root);
    }

    private static void leftViewOfBinaryTree(TreeNode root){
        if(root == null){
            return;
        }
        Map<Integer, Integer> map = new LinkedHashMap<>();
        Stack<TreeNode> currentStack = new Stack<>();
        Stack<TreeNode> nextStack = new Stack<>();
        currentStack.push(root);
        int index = 0;
        while (!currentStack.isEmpty()){
            TreeNode node = currentStack.pop();
            if(!map.containsKey(index)){
                map.put(index,node.val);
                System.out.println(node.val);
            }
            if(node.left != null){
                nextStack.push(node.left);
            }

            if(node.right != null){
                nextStack.push(node.right);
            }
            if(currentStack.isEmpty()){
                while (!nextStack.isEmpty()){
                    currentStack.push(nextStack.pop());
                }
                index++;
            }
        }
    }
}
