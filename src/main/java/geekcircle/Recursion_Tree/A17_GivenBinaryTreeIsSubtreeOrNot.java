package com.geekcircle.Recursion_Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-12
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

public class A17_GivenBinaryTreeIsSubtreeOrNot {
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



        TreeNode root1 = new TreeNode(1,new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5, null, new TreeNode(7)), new TreeNode(6)));
        TreeNode root2 = new TreeNode(3, new TreeNode(5, null, null), null);
        System.out.println(isGivenTreeIsSubtreeOrNot(root1,root2, false));
    }


    private static boolean isGivenTreeIsSubtreeOrNot(TreeNode root1, TreeNode root2, boolean check){
        if(root1 == null || root2 == null){
            return false;
        }

        if(root1.val == root2.val && !check){
            check = true;
        }

        if((root2.left != null && root1.left == null) || (root2.right != null && root1.right == null)){
            return false;
        }

        boolean left = false;
        if(check && root1.left != null && root2.left != null){
            left = isGivenTreeIsSubtreeOrNot(root1.left, root2.left, check);
        } else {
            if(check){
                left = true;
            } else {
                left = isGivenTreeIsSubtreeOrNot(root1.left, root2, check);
            }
        }

        boolean right = false;
        if(check && root1.right != null && root2.right != null){
            right = isGivenTreeIsSubtreeOrNot(root1.right, root2.right, check);
        } else {
            if(check){
                right = true;
            } else {
                right = isGivenTreeIsSubtreeOrNot(root1.right, root2, check);
            }
        }

        return left && right;
    }
}
