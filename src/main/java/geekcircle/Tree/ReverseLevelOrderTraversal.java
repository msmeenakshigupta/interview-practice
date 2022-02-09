package com.geekcircle.Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-29
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

import java.util.*;

public class ReverseLevelOrderTraversal {

    public static void main(String[] args) {

            /*
                        1
                       / \
                      2  3
                     /  /\
                    4  5 6
             */

        TreeNode root = new TreeNode(1,new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5), new TreeNode(6)));
        reverseLevelOrderTraversal(root);
    }

    static void reverseLevelOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }

        Map<Integer, List<TreeNode>> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> list = new ArrayList<>();
        stack.add(root);
        int index = 0;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node);
            if(node.left != null){
                list.add(node.left);
            }
        }
    }

}
