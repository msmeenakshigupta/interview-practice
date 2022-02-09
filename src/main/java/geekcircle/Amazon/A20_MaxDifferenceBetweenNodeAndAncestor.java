package com.geekcircle.Amazon;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-17
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

public class A20_MaxDifferenceBetweenNodeAndAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(2), new TreeNode(1));
        System.out.println(maxDifference(root, new TreeNode(0)));
    }

    private static int maxDifference(TreeNode root, TreeNode ancestor){
        if(root == null){
            return 0;
        }

        int prev = (ancestor.val - root.val);
        int left = maxDifference(root.left, root);
        int right = maxDifference(root.right, root);
        return Integer.max(Integer.max(left, right), prev);
    }
}
