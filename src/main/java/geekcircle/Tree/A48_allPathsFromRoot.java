package com.geekcircle.Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-07
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

public class A48_allPathsFromRoot {
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
        allPathFromRoot(root, "");
    }

    private static void allPathFromRoot(TreeNode root, String str){
        if(root.left != null){
            allPathFromRoot(root.left, str + " " + root.val);
        }
        if(root.right != null){
            allPathFromRoot(root.right, str + " " + root.val);
        }
        if(root.left == null && root.right == null){
            System.out.println(str + " " + root.val);
        }
    }
}
