package com.geekcircle.Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-06
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

class Height {
    int h;
}

public class A22_DiameterOfBinaryTree {
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

        TreeNode root = new TreeNode(1,new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5), new TreeNode(6, null, new TreeNode(7))));
        Height h = new Height();
        System.out.println(diameterOfTree(root, h));
    }

    private static int diameterOfTree(TreeNode root, Height height){
        if(root == null){
            height.h = 0;
            return 0;
        }

        Height lh = new Height();
        Height rh = new Height();

        int dLeft = diameterOfTree(root.left, lh);
        int dRight = diameterOfTree(root.right, rh);

        height.h = Math.max(lh.h, rh.h)+1;
        return Math.max(lh.h+rh.h+1, Math.max(dLeft, dRight));
    }

    private static int height(TreeNode root){
        if(root == null){
            return 0;
        }

        return Integer.max(height(root.left), height(root.right))+1;
    }
}
