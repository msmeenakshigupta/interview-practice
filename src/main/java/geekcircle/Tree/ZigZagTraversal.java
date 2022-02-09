package com.geekcircle.Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-28
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

import java.util.*;

public class ZigZagTraversal {

    public static void main(String[] args) {

            /*
                        1
                       / \
                      2  3
                     /  /\
                    4  5 6
             */

        TreeNode root = new TreeNode(1,new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5), new TreeNode(6)));
        zigzagTraversal(root);
    }

    static void zigzagTraversal(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> current = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        boolean leftToRight = true;
        current.push(root);
        while(!current.isEmpty()){
            TreeNode node = current.pop();
            System.out.println(node.val);
            if(leftToRight){
                if(node.left != null){
                    next.push(node.left);
                }
                if(node.right != null){
                    next.push(node.right);
                }
                leftToRight = false;
            } else {
                if(node.right != null){
                    next.push(node.right);
                }
                if(node.left != null){
                    next.push(node.left);
                }
                leftToRight = true;
            }
            if(current.isEmpty()){
                current = next;
                next = new Stack<>();

            }
        }
    }
}
