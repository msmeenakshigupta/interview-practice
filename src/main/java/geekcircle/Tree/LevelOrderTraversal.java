package com.geekcircle.Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-28
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

import java.util.*;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5), new TreeNode(6)));
        levelOrderTraversal(root);
    }

    static void levelOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList();
        Queue<TreeNode> newQueue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            System.out.println(level + " " + node.val);
            if(node.left != null){
                newQueue.add(node.left);
            }
            if(node.right != null){
                newQueue.add(node.right);
            }
            if(queue.isEmpty()){
                queue = newQueue;
                newQueue = new LinkedList<>();
                level++;
            }
        }
    }

    static void levelOrderTraversalApp2(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){

        }
    }

}
