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

public class InOrderTraversalBoth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5), new TreeNode(6)));
        inOrderTraversalIterative(root);
    }

    static void inOrderTraversalRecursive(TreeNode root){
        if(root == null){
            return;
        }
        inOrderTraversalRecursive(root.left);
        System.out.println(root.val);
        inOrderTraversalRecursive(root.right);
    }


    static void inOrderTraversalIterative(TreeNode root){
        if(root == null){
            return;
        }
        Map<TreeNode, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        map.put(root, 1);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(map.get(node) == 1){
                if(node.left != null){
                    stack.push(node.left);
                    map.put(node.left, 1);
                }
            } else if(map.get(node) == 2){
                System.out.println(node.val);
            } else if (map.get(node) == 3){
                if(node.right != null){
                    stack.push(node.right);
                    map.put(node.right, 1);
                }
            } else {
                stack.pop();
            }
            map.put(node, map.get(node) + 1);
        }
    }

}
