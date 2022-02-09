package com.geekcircle.Graph.SimpleGraph;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TravelSalesMan {
    static class Edge {
        int src;
        int des;
        int weight;

        public Edge(int src, int des, int weight) {
            this.src = src;
            this.des = des;
            this.weight = weight;
        }
    }

    static class Vertex {
        int num;
        int weight;

        public Vertex(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    static class Graph {

        List<List<Vertex>> graph = new LinkedList<>();
        public Graph(int N, List<Edge> edges) {
            for(int i = 0; i < N; i++){
                graph.add(new LinkedList<>());
            }
            for(Edge edge : edges){
                graph.get(edge.src).add(new Vertex(edge.des, edge.weight));
                graph.get(edge.des).add(new Vertex(edge.src, edge.weight));
            }
        }

        public void printGraph(){
            for(int i = 0; i < graph.size(); i++){
                System.out.print(i+" ");
                for (Vertex n : graph.get(i)){
                    System.out.print(" => "+n.num+"["+n.weight+"]");
                }
                System.out.println();
            }
        }

        public List<Vertex> getAdj(Integer item){
            return graph.get(item);
        }

    }

    public static void main(String[] args) {
        List<Edge> edges = new LinkedList<>(Arrays.asList(
                new Edge(0,1, 10),
                new Edge(0,2, 15),
                new Edge(0,3, 20),
                new Edge(1, 2, 35),
                new Edge(1,3,25),
                new Edge(2, 3, 30))
        );
        Graph graph = new Graph(4, edges);
        int source = 0;
        travelSalesMan(graph, source, source, new boolean[4], 0, source+"");
    }

    private static void travelSalesMan(Graph graph,Integer source, Integer current, boolean[] visited, Integer sum, String path){
        if(visited[source] && source == current){
            System.out.println(path +" "+sum);
            return;
        }

        visited[current] = true;
        List<Vertex> adj = graph.getAdj(current);
        for(Vertex v : adj){
            if(!visited[v.num] || (isAllVisited(visited) && v.num == source)){
                boolean[] newVisited = Arrays.copyOf(visited, visited.length);
                newVisited[v.num] = true;
                travelSalesMan(graph, source, v.num, newVisited,sum + v.weight, path +" "+v.num);
            }
        }
    }

    private static boolean isAllVisited(boolean[] visited){
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }

}
