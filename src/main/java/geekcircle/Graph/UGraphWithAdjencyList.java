package com.geekcircle.Graph;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-15
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/
import java.util.List;
import java.util.Map;

public class UGraphWithAdjencyList extends UndirectedGraph{
    public static void main(String[] args) {
        printGraph(graph);
    }

    private static void printGraph(Map<Integer, List<Integer>> graph){
        for(Integer i : graph.keySet()){
            for(Integer j : graph.get(i)){
                System.out.print(i + " => " + j + " ");
            }
            System.out.println();
        }
    }
}
