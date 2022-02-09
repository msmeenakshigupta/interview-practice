package com.geekcircle.Graph.SimpleGraph;

import java.util.*;

class Edge {
    int src;
    int des;

    public Edge(int src, int des) {
        this.src = src;
        this.des = des;
    }
}

class Graph {

    List<List<Integer>> graph = new LinkedList<>();
    public Graph(int N, List<Edge> edges) {
        for(int i = 0; i < N; i++){
            graph.add(new LinkedList<>());
        }
        for(Edge edge : edges){
            graph.get(edge.src).add(edge.des);
            graph.get(edge.des).add(edge.src);
        }
    }

    public void printGraph(){
        for(int i = 0; i < graph.size(); i++){
            System.out.print(i+" ");
            for (Integer n : graph.get(i)){
                System.out.print(" => "+n);
            }
            System.out.println();
        }
    }

    public List<Integer> getAdj(Integer item){
        return graph.get(item);
    }

}

public class BFS_DFS {

    public static void main(String[] args) {
        Graph graph = new Graph(5, Arrays.asList(
                new Edge(0,1),
                new Edge(0,4),
                new Edge(1,4),
                new Edge(1,3),
                new Edge(1,2),
                new Edge(2,3),
                new Edge(3,4))
        );
        //graph.printGraph();
        //BFS(graph);
        DFS(graph);
    }

    private static void BFS(Graph graph){
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visit = new LinkedHashSet<>();
        queue.add(0);
        visit.add(0);
        while (!queue.isEmpty()){
            Integer current = queue.poll();
            System.out.println(current);
            for(Integer integer : graph.getAdj(current)){
                if(!visit.contains(integer)){
                    visit.add(integer);
                    queue.add(integer);
                }
            }
        }
    }

    private static void DFS(Graph graph){
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visit = new LinkedHashSet<>();
        stack.add(0);
        visit.add(0);
        while (!stack.isEmpty()){
            Integer current = stack.pop();
            System.out.println(current);
            for(Integer integer : graph.getAdj(current)){
                if(!visit.contains(integer)){
                    visit.add(integer);
                    stack.add(integer);
                }
            }
        }
    }

}
