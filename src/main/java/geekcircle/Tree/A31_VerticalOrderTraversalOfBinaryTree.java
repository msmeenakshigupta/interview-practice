package com.geekcircle.Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-07
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

import java.util.*;

public class A31_VerticalOrderTraversalOfBinaryTree {
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
        Map<Integer, List<Integer>> map = new HashMap<>();
        verticalOrderTraversal(root, 7, map);
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            Integer sum = 0;
            for(Integer num : entry.getValue()){
                sum += num;
            }
            System.out.println(sum);
        }
    }

    private static void verticalOrderTraversal(TreeNode root, Integer hf, Map<Integer, List<Integer>> map){
        if(root == null){
            return;
        }
        Integer key = hf;
        List<Integer> list = null;
        if(map.containsKey(key)){
            list = map.get(key);
        } else {
            list = new ArrayList<>();
        }
        list.add(root.val);
        map.put(hf,list);
        verticalOrderTraversal(root.left, hf - 1, map);
        verticalOrderTraversal(root.right, hf + 1, map);
    }

}
