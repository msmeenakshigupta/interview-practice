package com.geekcircle.Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-08
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

import java.util.*;

public class A49_IterativeRootToLeafPath {
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
        printRootToLeafPathIterative(root);
    }

    private static void printRootToLeafPathIterative(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> list = new ArrayList<>();
        stack.add(root);
        list.add(root);
        int index = 0;
        while (!stack.isEmpty()){
            TreeNode node = list.get(index);
            if(node.left == null && node.right == null){
                for(TreeNode n : list){
                    System.out.print(n.val + " ");
                }
                System.out.println();
                while(!stack.isEmpty() && list.get(index) == stack.peek()){
                    list.remove(stack.pop());
                    index--;
                }
            }

            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
            if(!stack.isEmpty()){
                list.add(stack.peek());
                index++;
            }
        }
    }
}
