package com.geekcircle.Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-06
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class A13_TopViewOfBinaryTree {
    public static void main(String[] args) {
        /*
                        1
                       / \
                      2  3
                     /  /\
                    4  5 6
             */

        TreeNode root = new TreeNode(1,new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5), new TreeNode(6)));
        topViewOfTree(root);
    }

    private static void topViewOfTree(TreeNode root){
        if(root == null){
            return;
        }

        Map<TreeNode, Integer> lookup = new LinkedHashMap<>();
        Map<Integer, Integer> view = new LinkedHashMap<>();
        Stack<TreeNode> currentStack = new Stack<>();
        currentStack.push(root);
        lookup.put(root, 0);
        while (!currentStack.isEmpty()){
            TreeNode node = currentStack.pop();
            int bf = lookup.get(node);
            if(!view.containsKey(bf)){
                view.put(bf, node.val);
            }
            System.out.println(node.val + " " + bf);
            if(node.left != null){
                lookup.put(node.left, bf - 1);
                currentStack.push(node.left);
            }
            if(node.right != null){
                lookup.put(node.right, bf + 1);
                currentStack.push(node.right);
            }
        }
    }
}
