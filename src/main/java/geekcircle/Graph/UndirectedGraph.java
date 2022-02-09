package com.geekcircle.Graph;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-15
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndirectedGraph {
    protected static int V = 5;
    protected static Map<Integer, List<Integer>> graph = new HashMap<>(V);
    UndirectedGraph(){
        addEdgeBetweenVertex(graph, 0,1);
        addEdgeBetweenVertex(graph, 0,4);
        addEdgeBetweenVertex(graph, 1,4);
        addEdgeBetweenVertex(graph, 1,3);
        addEdgeBetweenVertex(graph, 1,2);
        addEdgeBetweenVertex(graph, 2,3);
        addEdgeBetweenVertex(graph, 3,4);
    }

    private static void addEdgeBetweenVertex(Map<Integer, List<Integer>> graph, int a, int b){
        List<Integer> list = new ArrayList<>();
        if(graph.containsKey(a)){
            list = graph.get(a);
        }
        list.add(b);
        graph.put(a, list);
        list = new ArrayList<>();
        if(graph.containsKey(b)){
            list = graph.get(b);
        }
        list.add(a);
        graph.put(b,list);
    }

}
