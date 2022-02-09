package com.geekcircle.Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-29
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

import java.util.Stack;

//Spiral Means ZigZag Traversal
public class SpiralTraversal {

    public static void main(String[] args) {

            /*
                        1
                       / \
                      2  3
                     /  /\
                    4  5 6
             */

        TreeNode root = new TreeNode(1,new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5), new TreeNode(6)));
        spiralTraversal(root);
    }

    static void spiralTraversal(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> current = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        current.push(root);
        boolean leftToRight = true;
        while(!current.isEmpty()) {
            TreeNode node = current.pop();
            System.out.println(node.val);
            if(leftToRight){
                if(node.left != null){
                    next.push(node.left);
                }

                if(node.right != null) {
                    next.push(node.right);
                }
            } else {
                if(node.right != null){
                    next.push(node.right);
                }
                if(node.left != null){
                    next.push(node.left);
                }
            }
            if(current.isEmpty()){
                current = next;
                next = new Stack<>();
                leftToRight = !leftToRight;
            }
        }
    }

}
