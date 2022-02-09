package com.geekcircle.Graph;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-15
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.*;

public class UGraph_DFS extends UndirectedGraph {
    public static void main(String[] args) {
        Set<Integer> visit = new HashSet<>();
        visit.add(0);
        System.out.println("Recursion");
        DFSRecursion(graph, 0, visit);
        System.out.println("Iterative");
        DFSIterative(graph, 0);
    }

    private static void DFSIterative(Map<Integer, List<Integer>> graph, int src){
        Set<Integer> set = new HashSet<>();
        Stack<Integer> queue = new Stack<>();
        queue.push(src);
        set.add(src);
        while (!queue.isEmpty()){
            Integer curr = queue.pop();
            System.out.println(curr);
            List<Integer> adj = graph.get(curr);
            for(int i = 0; i < adj.size(); i++){
                if(!set.contains(adj.get(i))){
                    set.add(adj.get(i));
                    queue.add(adj.get(i));
                }
            }
        }
    }

    private static void DFSRecursion(Map<Integer, List<Integer>> graph, int curr, Set<Integer> visit){
        System.out.println(curr + " ");
        List<Integer> list = graph.get(curr);
        for(int i = 0; i < list.size(); i++){
            if(!visit.contains(list.get(i))){
                visit.add(list.get(i));
                DFSRecursion(graph, list.get(i), visit);
            }
        }
    }
}
