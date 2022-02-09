package com.geekcircle.Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-28
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PostOrderTraversal {

    public static void main(String[] args) {

            /*
                        1
                       / \
                      2  3
                     /  /\
                    4  5 6
             */

        TreeNode root = new TreeNode(1,new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5), new TreeNode(6)));
        postOrderTraversalIterative(root);
    }

    static void postOrderTraversalRecursive(TreeNode root){
        if (root == null) {
            return;
        }
        postOrderTraversalRecursive(root.left);
        postOrderTraversalRecursive(root.right);
        System.out.println(root.val);
    }

    static void postOrderTraversalIterative(TreeNode root){
        if(root == null){
            return;
        }
        Map<TreeNode, Integer> map = new HashMap<>();
        Stack<TreeNode>  stack = new Stack<>();
        stack.push(root);
        map.put(root, 1);
        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if(map.get(node) == 1){
                if(node.left != null){
                    stack.push(node.left);
                    map.put(node.left, 1);
                }
            } else if(map.get(node) == 2){
                if(node.right != null){
                    stack.push(node.right);
                    map.put(node.right, 1);
                }
            } else if(map.get(node) == 3){
                System.out.println(node.val);
            } else {
                stack.pop();
            }
            map.put(node, map.get(node) + 1);
        }
    }

}
