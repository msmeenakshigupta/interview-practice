package com.geekcircle.Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-28
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

public class HeightOfTree {

    public static void main(String[] args) {

            /*
                        1
                       / \
                      2  3
                     /  /\
                    4  5 6
             */

        TreeNode root = new TreeNode(1,new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5), new TreeNode(6)));
        System.out.println(heightOfTree(root));
    }

    static int heightOfTree(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);
        return left > right ? left + 1 : right + 1;
    }
}
