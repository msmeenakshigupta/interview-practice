package com.geekcircle.Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-06
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

public class A27_AllPathFromRootToLeaf {
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
        allPathFromRootToLeaf(root, "");
    }

    private static void allPathFromRootToLeaf(TreeNode root, String str){
        if(root.left == null && root.right == null){
            System.out.println(str +" "+root.val);
            return;
        }
        if(root.left != null){
            allPathFromRootToLeaf(root.left, str + " " + root.val);
        }
        if(root.right != null){
            allPathFromRootToLeaf(root.right, str + " " + root.val);
        }
    }
}
