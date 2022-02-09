package com.geekcircle.Graph;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-15
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DSourceToDestination extends DirectedGraph {
    public static void main(String[] args) {
        create();
        Set<Integer> visit = new HashSet<>();
        visit.add(5);
        pathFromSourceToDestination(graph, 5, 3, "5", visit);
    }

    private static void pathFromSourceToDestination(Map<Integer, List<Integer>> graph, int source, int destination, String path, Set<Integer> visit){
        if(source == destination){
            System.out.println(path);
        }
        List<Integer> list = graph.get(source);
        if(list != null){
            for(int i = 0; i < list.size(); i++){
                if(!visit.contains(list.get(i))){
                    visit.add(list.get(i));
                    pathFromSourceToDestination(graph, list.get(i), destination, path +" "+list.get(i), visit);
                    visit.remove(list.get(i));
                }
            }
        }
    }
}
