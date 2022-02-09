package com.geekcircle.Recursion_Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-03
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;


public class A3_DeleteGivenBinaryTree {
    public static void main(String[] args) {
        //LRN
        /*
                        1
                       / \
                      2  3
                     /  /\
                    4  5 6
             */

        TreeNode root = new TreeNode(1,new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5), new TreeNode(6)));
        deleteGivenBinaryTree(root);

    }

    private static void deleteGivenBinaryTree(TreeNode root){
        if(root == null){
            return;
        }
        deleteGivenBinaryTree(root.left);
        deleteGivenBinaryTree(root.right);
        if(root.left != null){
            System.out.println("Deleted "+ root.left.val);
            root.left = null;
        }
        if(root.right != null){

            System.out.println("Deleted "+ root.right.val);
            root.right = null;
        }
    }


}
