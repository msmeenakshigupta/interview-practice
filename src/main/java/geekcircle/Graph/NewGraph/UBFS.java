package com.geekcircle.Graph.NewGraph;

import com.geekcircle.GraphEdge;
import com.geekcircle.GraphVertex;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Graph <T> {

    Map<GraphVertex<T>, List<GraphVertex<T>>> graph;

    public Graph(List<GraphVertex<T>> vertices, List<GraphEdge<T>> edges) {
        graph = new LinkedHashMap<>();
        for(GraphVertex<T> vertex : vertices){
            graph.put(vertex, new LinkedList<>());
        }

        for(GraphEdge<T> edge : edges){
            graph.get(edge.getSrc()).add(edge.getDst().setWeight(edge.getWeight()));
            if(!edge.isDirected()){
                graph.get(edge.getDst()).add(edge.getSrc().setWeight(edge.getWeight()));
            }
        }
    }

    public void printGraph(){
        for(Map.Entry<GraphVertex<T>, List<GraphVertex<T>>> entry : graph.entrySet()){
            List<GraphVertex<T>> adj = entry.getValue();
            System.out.print(entry.getKey().getNumber());
            for(GraphVertex<T> vertex : adj){
                System.out.print(" => "+vertex.getNumber() +"["+vertex.getWeight()+"]");
            }
            System.out.println();
        }
    }
}

public class UBFS {
    public static void main(String[] args) {
        List<GraphVertex<Integer>> vertices = new LinkedList<>();
        for(int i = 0; i < 5; i++){
            vertices.add(new GraphVertex<>(i));
        }
        List<GraphEdge<Integer>> edges = new LinkedList<>();
        edges.add(new GraphEdge<>(vertices.get(0), vertices.get(1), 1));
        edges.add(new GraphEdge<>(vertices.get(0), vertices.get(4)));
        edges.add(new GraphEdge<>(vertices.get(1), vertices.get(4)));
        edges.add(new GraphEdge<>(vertices.get(1), vertices.get(3)));
        edges.add(new GraphEdge<>(vertices.get(1), vertices.get(2)));
        edges.add(new GraphEdge<>(vertices.get(2), vertices.get(3)));
        edges.add(new GraphEdge<>(vertices.get(3), vertices.get(4)));
        Graph graph = new Graph(vertices, edges);
        graph.printGraph();
    }
}
