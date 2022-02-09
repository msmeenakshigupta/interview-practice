package com.geekcircle.Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-06
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

import java.util.Stack;

public class A28_AncestorOfGivenNode {
    public static void main(String[] args) {
        /*
                        1
                       / \
                      2  3
                     /  /\
                    4  5 6
                       \
                       7
             */

        TreeNode root = new TreeNode(1,new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5, null, new TreeNode(7)), new TreeNode(6)));
        TreeNode an = ancestorOfGivenNode(root, 7, root);
        System.out.println(an.val);
    }

    private static TreeNode ancestorOfGivenNode(TreeNode root, Integer val, TreeNode prev){
        if(root == null){
            return null;
        }

        if(root.val == val){
            return prev;
        }

        TreeNode left = ancestorOfGivenNode(root.left, val, root);
        TreeNode right = ancestorOfGivenNode(root.right, val, root);
        if(left != null){
            return left;
        }

        if(right != null){
            return right;
        }

        return null;
    }
}
