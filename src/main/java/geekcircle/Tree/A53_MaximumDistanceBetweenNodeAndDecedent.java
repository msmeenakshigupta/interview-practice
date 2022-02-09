package com.geekcircle.Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-09
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

public class A53_MaximumDistanceBetweenNodeAndDecedent {

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

        TreeNode root = new TreeNode(1,new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5, null, new TreeNode(10)), new TreeNode(6)));
        System.out.println(maxDifference(root, root.val, root.val));
    }

    private static int maxDifference(TreeNode root, int min, int max){
        if(root == null){
            return max-min;
        }

        if(root.val < min){
            min = root.val;
        }

        if(root.val > max){
            max = root.val;
        }

        int left = maxDifference(root.left, min, max);
        int right = maxDifference(root.right, min, max);
        return Integer.max(left, right);
    }
}
