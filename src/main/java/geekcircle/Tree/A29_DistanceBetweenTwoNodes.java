package com.geekcircle.Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-07
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

public class A29_DistanceBetweenTwoNodes {
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
        System.out.println(distanceBetweenTwoNodes(root, 5, 6));
    }

    static boolean found = false;
    private static int distanceBetweenTwoNodes(TreeNode root, Integer node1, Integer node2){
        if(root == null){
            return 0;
        }

        if(root.val == node1 || root.val == node2){
            return 1;
        }

        int left = distanceBetweenTwoNodes(root.left, node1, node2);
        int right = distanceBetweenTwoNodes(root.right, node1, node2);

        if(left != 0 && right != 0){
            found = true;
            return left+right;
        }

        if (left != 0){
            if(found){
                return left;
            }
            return left+1;
        }

        if(right != 0){
            if(found){
                return right;
            }
            return right+1;
        }
        return 0;
    }

    private static int distanceBetweenTwoNodesNew(TreeNode root, Integer node1, Integer node2){
        if(root == null){
            return 0;
        }
        int n1l = heightFromRoot(root, node1);
        int n2l = heightFromRoot(root, node2);
        return 0;
    }

    private static int heightFromRoot(TreeNode root, int val){
        if(root.val == val){
            return 1;
        }

        int left = 0, right = 0;
        if(root.left != null){
            left = heightFromRoot(root.left, val);
        }

        if(root.right != null){
            right = heightFromRoot(root.right, val);
        }
        int max = Integer.max(left, right);
        return (max != 0) ? max + 1 : max;
    }

    private static int lca(TreeNode root, int node1, int node2){
        return 0;
    }
}
