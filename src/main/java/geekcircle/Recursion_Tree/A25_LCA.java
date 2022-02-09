package com.geekcircle.Recursion_Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-12
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

import java.util.List;

public class A25_LCA {
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
        TreeNode lca = findLca(root, 8,3);
    }

    private static TreeNode findLca(TreeNode root, int a, int b){
        if(root == null){
            return null;
        }
        return null;
    }


    private List<TreeNode> pathToNode(TreeNode root, int a){
        if(root == null){
            return null;
        }

        if(root.val == a){

        }
        return null;
    }

}
