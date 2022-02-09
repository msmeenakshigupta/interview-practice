package com.geekcircle.Graph;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-15
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.*;

public class UGraph_BFS extends UndirectedGraph{
    public static void main(String[] args) {
        BFS(graph, 0);
    }

    private static void BFS(Map<Integer, List<Integer>> graph, int src){
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        set.add(src);
        while (!queue.isEmpty()){
            Integer curr = queue.remove();
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
}
