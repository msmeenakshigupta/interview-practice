package com.geekcircle.Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-07
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

public class A40_MaxSumRootToLeaf {
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
        int sum = maxSumRootToLeaf(root);
        System.out.println("Sum : "+sum);
        printPath(root, sum);
    }

    private static int maxSumRootToLeaf(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = maxSumRootToLeaf(root.left);
        int right = maxSumRootToLeaf(root.right);

        return Integer.max(left, right)+root.val;
    }

    private static boolean printPath(TreeNode root, int sum){
        if(sum == 0){
            return true;
        }

        if(root == null){
            return false;
        }

        boolean left = printPath(root.left, sum - root.val);
        boolean right = printPath(root.right, sum - root.val);

        if(left || right){
            System.out.println(root.val);
        }
        return left || right;
    }
}
