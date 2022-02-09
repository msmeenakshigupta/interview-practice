package com.geekcircle.Top100;

import com.geekcircle.Vertex;

import java.util.*;


public class A63_MaximumCostPathInGraph {
    public static void main(String[] args) {
        int[][] graph = {
                            {0,5,0,0,0,0,11,0},
                            {5,0,7,0,0,5,3,6},
                            {0,7,0,-8,0,-1,0,0},
                            {0,0,-8,0,10,9,0,0},
                            {0,0,0,10,0,1,0,0},
                            {0,5,-1,9,1,0,2,0},
                            {11,3,0,0,0,2,0,9},
                            {0,6,0,0,0,0,9,0}
                        };

        List<Vertex> vertices = new ArrayList<>();
        Map<Vertex, List<Vertex>> vertexListMap = new LinkedHashMap<>();

        for(int i = 0; i < graph.length; i++){
            vertices.add(new Vertex(i, 0));
            vertexListMap.put(vertices.get(i), new ArrayList<>());
        }

        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] != 0){
                    List<Vertex> vertexList = vertexListMap.get(vertices.get(i));
                    vertexList.add(vertices.get(j));
                }
            }
        }

        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> stack = new LinkedList<>();
        Vertex source = vertices.get(0);
        Vertex destination = vertices.get(3);
        stack.add(source);
        visited.add(source);
        while (!stack.isEmpty()){
            Vertex current = stack.poll();
            visited.add(current);
            if(current == destination){
                for(Vertex vertex : current.getPath()){
                    System.out.print(vertex.getNumber()+" ");
                }
                System.out.println(current.getWeight());
            }
            for(Vertex adj : vertexListMap.get(current)){
                if(!visited.contains(adj)){
                    adj.setWeight(current.getWeight() + graph[current.getNumber()][adj.getNumber()]);
                    adj.addAllPath(current.getPath());
                    stack.add(adj);
                }
            }
        }
    }
}
