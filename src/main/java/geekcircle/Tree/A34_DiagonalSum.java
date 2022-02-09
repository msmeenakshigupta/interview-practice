package com.geekcircle.Tree;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-07
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A34_DiagonalSum {
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
        diagonalSum(root, map, 0);
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            Integer sum = 0;
            for(Integer val : entry.getValue()){
                sum += val;
            }
            System.out.println(entry.getKey() + " "+ sum);
        }
    }

    private static void diagonalSum(TreeNode root, Map<Integer, List<Integer>> map, Integer diagonal){
        if(root == null){
            return;
        }

        List<Integer> list = new ArrayList<>();
        if(map.containsKey(diagonal)){
            list = map.get(diagonal);
        }
        list.add(root.val);
        map.put(diagonal, list);
        diagonalSum(root.left, map, diagonal+1);
        diagonalSum(root.right, map, diagonal);
    }
}
