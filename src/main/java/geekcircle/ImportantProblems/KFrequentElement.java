package com.geekcircle.ImportantProblems;


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Pair {
    Integer num;
    Integer freq;

    public Pair(Integer num, Integer freq) {
        this.num = num;
        this.freq = freq;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "num=" + num +
                ", freq=" + freq +
                '}';
    }
}

public class KFrequentElement {
    public static void main(String[] args) {
        int[] arr = {4,1,-1,2,-1,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequentElements(arr, k)));
        System.out.println(Arrays.toString(topKFrequentElementsOptimized(arr, k)));
    }

    //Using Priority Queue size equal to array size
    private static int[] topKFrequentElements(int[] arr, int k){
        System.out.println("topKFrequentElements");
        Map<Integer, Integer> lookup = new LinkedHashMap<>();
        int[] result = new int[k];
        int length = arr.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(length, (a, b)->b.freq-a.freq);
        for(int i = 0; i < length; i++ ){
            int ctr = 0;
            if(lookup.containsKey(arr[i])){
                ctr = lookup.get(arr[i]);
            }
            lookup.put(arr[i], ++ctr);
        }
        for(Integer i : lookup.keySet()){
            pq.add(new Pair(i, lookup.get(i)));
        }
        for(int i = 0; i < k; i++){
            result[i] = pq.poll().num;
        }
        return result;
    }

    //Using PriorityQueue of size equal to K O(n) + o(n + k) Space
    private static int[] topKFrequentElementsOptimized(int[] arr, int k){
        System.out.println("topKFrequentElementsOptimized");
        int[] result = new int[k];
        if(k == 0){
            return result;
        }
        Map<Integer, Integer> lookup = new LinkedHashMap<>();
        int length = arr.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, (a, b)->a.freq-b.freq);
        for(int i = 0; i < length; i++ ){
            int ctr = 0;
            if(lookup.containsKey(arr[i])){
                ctr = lookup.get(arr[i]);
            }
            lookup.put(arr[i], ++ctr);
        }
        int j = 0;
        for(Integer i : lookup.keySet()){
            if(j++ < k){
                pq.add(new Pair(i, lookup.get(i)));
            } else {
                if(pq.peek().freq <= lookup.get(i)){
                    pq.poll();
                    pq.add(new Pair(i, lookup.get(i)));
                }
            }
        }
        for(int i = 0; i < k; i++){
            result[i] = pq.poll().num;
        }
        return result;
    }
}
