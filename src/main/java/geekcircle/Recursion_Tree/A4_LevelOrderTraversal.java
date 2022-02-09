package com.geekcircle.Recursion_Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-03
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class A4_LevelOrderTraversal {
    public static void main(String[] args) {
            /*
                        1
                       / \
                      2  3
                     /  /\
                    4  5 6
             */

        TreeNode root = new TreeNode(1,new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5), new TreeNode(6)));
        levelOrderTraversal(root);
    }

    private static void levelOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> currentQueue = new LinkedList<>();
        Queue<TreeNode> nextQueue = new LinkedList<>();
        currentQueue.add(root);
        while (!currentQueue.isEmpty()) {
            TreeNode node = currentQueue.remove();
            System.out.print(node.val+" ");
            if(node.left != null){
                nextQueue.add(node.left);
            }
            if(node.right != null){
                nextQueue.add(node.right);
            }
            if(currentQueue.isEmpty()){
                currentQueue = nextQueue;
                nextQueue = new LinkedList<>();
                System.out.println();
            }
        }
    }
}
