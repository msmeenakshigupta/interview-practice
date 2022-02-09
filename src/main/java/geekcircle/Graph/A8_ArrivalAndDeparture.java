package com.geekcircle.Graph;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-15
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.*;

public class A8_ArrivalAndDeparture extends DirectedGraph {
    public static void main(String[] args) {
        create();
        Set<Integer> visit = new HashSet<>();
        visit.add(5);
        arrivalAndDeparture(graph, 5, visit);
    }

    private static int n = 0;
    private static void arrivalAndDeparture(Map<Integer, List<Integer>> map, int source, Set<Integer> visit){
        if(map.containsKey(source)){
            List<Integer> list = map.get(source);
            int first = n;
            for(int i = 0; i < list.size(); i++){
                if(!visit.contains(list.get(i))){
                    visit.add(list.get(i));
                    n++;
                    arrivalAndDeparture(map, list.get(i), visit);
                    visit.remove(list.get(i));
                }
            }
            System.out.println(source+"=>("+first+","+(n++)+")");
        }
    }
}
