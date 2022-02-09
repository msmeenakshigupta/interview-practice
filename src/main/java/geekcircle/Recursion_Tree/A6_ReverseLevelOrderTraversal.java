package com.geekcircle.Recursion_Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-03
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

import java.util.Stack;

public class A6_ReverseLevelOrderTraversal {
    public static void main(String[] args) {
        /*
                        1
                       / \
                      2  3
                     /  /\
                    4  5 6
             */

        TreeNode root = new TreeNode(1,new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5), new TreeNode(6)));
        reverseLevelOrderTraversal(root);
    }

    private static void reverseLevelOrderTraversal(TreeNode root){

    }
}
