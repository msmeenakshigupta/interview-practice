package com.geekcircle.Recursion_Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-11
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

public class A14_BinaryTreeToSumTree {
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
        System.out.println(sumTree(root));
    }

    private static int sumTree(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = sumTree(root.left);
        int right = sumTree(root.right);
        root.val = left + right + root.val;
        return root.val;
    }
}
