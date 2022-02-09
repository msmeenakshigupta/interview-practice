package com.geekcircle.Graph;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-15
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.*;

public class USmallestPathFromSourceToDestination extends UndirectedGraph {
    public static void main(String[] args) {
        Set<Integer> visit = new HashSet<>();
        visit.add(0);
        shortestPathFromSourceToDestination(graph, 0, 2, "0 ", visit);
    }

    private static void shortestPathFromSourceToDestination(Map<Integer, List<Integer>> graph, int source, int destination, String path, Set<Integer> visit){
        if(source == destination){
            System.out.println(path);
        }

        List<Integer> list = graph.get(source);
        for(int i = 0; i < list.size(); i++){
            if(!visit.contains(list.get(i))){
                visit.add(list.get(i));
                shortestPathFromSourceToDestination(graph, list.get(i), destination, path + " "+ list.get(i), visit);
                visit.remove(list.get(i));
            }
        }
    }
}
