package com.geekcircle.Flipkart;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class A5_WordLadder {
    public static void main(String[] args) {
        String[] strings = {"ABCD", "EBAD", "EBCD", "XYZA"};
        boolean[] visited = new boolean[strings.length];
        String source = "ABCV";
        String target = "EBAD";
        sourceToDestination(strings, source, target, 1, "", visited);
    }

    private static void sourceToDestination(String[] strings, String source, String target, int n, String path, boolean[] visited){
        if(source.equals(target)){
            System.out.println(path + " Size : "+n);
            return;
        }
        boolean[] newVisited = Arrays.copyOf(visited, visited.length);
        Queue<Integer> integers = possibleStrings(strings, source, target, visited);
        if(integers.isEmpty()){
            return;
        } else {
            while (!integers.isEmpty()){
                int ind = integers.poll();
                String current = strings[ind];
                newVisited[ind] = true;
                sourceToDestination(strings, current, target, n+1, path+" "+current, newVisited);
            }
        }
    }

    private static Queue<Integer> possibleStrings(String[] strings, String source, String target, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < strings.length; i++){
            if(!visited[i]){
                int ctr = 0;
                for(int j = 0; j < strings[i].length(); j++){
                    if(source.charAt(j) != strings[i].charAt(j) ){
                        ctr++;
                    }
                }
                if(ctr == 1){
                    queue.add(i);
                }
            }
        }
        return queue;
    }
}
