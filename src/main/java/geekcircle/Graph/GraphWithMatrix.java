package com.geekcircle.Graph;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-15
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class GraphWithMatrix {
    public static void main(String[] args) {
        int V = 5;
        int[][] graph = new int[V][V];
        addEdgeBetweenVertex(graph, 0,1);
        addEdgeBetweenVertex(graph, 0,4);
        addEdgeBetweenVertex(graph, 1,4);
        addEdgeBetweenVertex(graph, 1,3);
        addEdgeBetweenVertex(graph, 1,2);
        addEdgeBetweenVertex(graph, 2,3);
        addEdgeBetweenVertex(graph, 3,4);
        printGraph(graph);
    }

    private static void addEdgeBetweenVertex(int[][] graph, int a, int b){
        int n = graph.length;
        if(a < n && a >= 0 && b < n && b >= 0){
            graph[a][b] = graph[b][a] = 1;
        }
    }

    private static void printGraph(int[][] graph){
        int n = graph.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

}
