package com.geekcircle.Recursion_Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-02
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

import java.util.Stack;

public class A1_IdenticalTree {
    public static void main(String[] args) {
        /*
                        1
                       / \
                      2  3
                     /  /\
                    4  5 6
             */

        TreeNode root1 = new TreeNode(1,new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5), new TreeNode(6)));
        TreeNode root2 = new TreeNode(6,new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5), null));
        //System.out.println(identicalRecursive(root1, root2));
        System.out.println(identicalIterative(root1, root2));
    }

    //Self Solution (Recursive)
    static boolean identicalRecursive(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }

        if((root1 == null && root2 != null) || (root1 != null && root2 == null)){
            return false;
        }

        boolean left = identicalRecursive(root1.left, root2.left);
        boolean right = identicalRecursive(root1.right, root2.right);
        return left && right;
    }

    static boolean identicalIterative(TreeNode root1, TreeNode root2){
        if(root1 == root2 && root1 == null){
            return true;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root1);
        stack2.add(root2);
        while (!stack1.isEmpty()){
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            if((node1.left != null && node2.left == null) || (node2.left != null && node1.left == null)){
                return false;
            }
            if(node1.left != null){
                stack1.add(node1.left);
                stack2.add(node2.left);
            }

            if((node1.right != null && node2.right == null) || (node2.right != null && node1.right == null)){
                return false;
            }

            if(node1.right != null){
                stack1.add(node1.right);
                stack2.add(node2.right);
            }
        }
        return true;
    }

}
