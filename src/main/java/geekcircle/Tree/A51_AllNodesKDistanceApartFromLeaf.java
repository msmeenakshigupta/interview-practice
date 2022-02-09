package com.geekcircle.Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-09
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

public class A51_AllNodesKDistanceApartFromLeaf {
    //If We want
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
        nodesKDistanceApart(root, 1);
    }

    private static int nodesKDistanceApart(TreeNode root, int k){
        if(root == null){
            return 0;
        }

        int left = nodesKDistanceApart(root.left, k) + 1;
        int right = nodesKDistanceApart(root.right, k) + 1;

        if(left == k || right == k){
            System.out.println(root.val);
        }
        return Integer.max(left, right);
    }
}
