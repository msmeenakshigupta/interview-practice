package com.geekcircle.Heap;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-26
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.*;

public class KFrequentCharacters {

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,3,4,4};
        int k = 3;
        System.out.println(Arrays.toString(kMostFrequentCharactersUsingHeap(arr, k)));
    }

    static int[] kMostFrequentCharactersUsingHeap(int[] arr, int k){
        int[] result = new int[k];
        Map<Integer,Integer> lookup = new LinkedHashMap<>();
        Comparator<Pair> comparator = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.frequency - o1.frequency;
            }
        };

        for(int i = 0; i < arr.length; i++){
            if(lookup.containsKey(arr[i])){
                lookup.put(arr[i], lookup.get(arr[i]) + 1);
            } else {
                lookup.put(arr[i], 1);
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(comparator);
        for(Map.Entry<Integer, Integer> entry : lookup.entrySet()){
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }

        int i = 0;
        while (!pq.isEmpty() && i < k){
            result[i++] = pq.poll().item;
        }
        return result;
    }
}

class Pair {
    int item;
    int frequency;

    public Pair(int item, int frequency) {
        this.item = item;
        this.frequency = frequency;
    }
}
