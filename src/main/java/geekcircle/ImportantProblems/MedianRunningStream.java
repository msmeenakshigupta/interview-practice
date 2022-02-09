package com.geekcircle.ImportantProblems;

import java.util.*;

public class MedianRunningStream {
    public static void main(String[] args) {
        int[] arr = {1,3,2,66,5,4};
        runningMedianInStreamApproach1(arr);
        runningMedianInStreamApproach3(arr);
    }

    //k * nlogn
    private static void runningMedianInStreamApproach1(int[] arr){
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < arr.length; i++){
            list.add(arr[i]);
            Collections.sort(list);
            int size = list.size();
            if(size % 2 == 0) {
                //System.out.println("First : "+list.get((int) size /2) + " Last: "+list.get(((int) size /2) - 1));
                System.out.println("Median : " + (list.get((int) size /2) + list.get(((int) size /2) - 1)) / 2.0 );
            } else {
                System.out.println("Median : " + list.get((int)Math.ceil((int) size / 2)));
            }
        }
        System.out.println();
    }

    private static void runningMedianInStreamApproach2(int[] arr){
        int[] tarr = new int[arr.length];
        int l = 0;
        for(int i = 0; i < arr.length; i++){
            l+=1;
            insertionSort(tarr, l, arr[i]);
            int size = l;
            if(size % 2 == 0) {
                System.out.println("First : "+tarr[(int) size /2] + " Last: "+tarr[((int) size /2) - 1] / 2.0);
                System.out.println("Median : " + ((tarr[(int) size /2] + tarr[((int) size /2) - 1]) / 2.0 ));
            } else {
                System.out.println("Median : " + tarr[(int)Math.ceil((int) size / 2)]);
            }
        }
    }

    private static void insertionSort(int[] tarr, int n, int val){
        if(n == 1){
            tarr[0] = val;
            return;
        }
        boolean found = false;
        for(int i = 0; i < n; i++){
            if(val < tarr[i]){
                found = true;
                for(int j = n-1; j > i; j--){
                    tarr[j] = tarr[j-1];
                }
                tarr[i] = val;
                break;
            }
        }
        if(!found){
            tarr[n-1] = val;
        }
    }

    //O(nlogn)
    private static void runningMedianInStreamApproach3(int[] arr){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < arr.length; i++){
            if(minHeap.isEmpty() || arr[i] > minHeap.peek()){
                minHeap.add(arr[i]);
            } else {
                maxHeap.add(arr[i]);
            }
            if(Math.abs(minHeap.size() - maxHeap.size()) > 1){
                if(minHeap.size() > maxHeap.size()){
                    maxHeap.add(minHeap.poll());
                } else {
                    minHeap.add(maxHeap.poll());
                }
            }
            if(minHeap.size() == maxHeap.size()){
                System.out.println("Median "+ ((minHeap.peek() + maxHeap.peek()) / 2.0));
            } else {
                if(minHeap.size() > maxHeap.size()){
                    System.out.println("Median "+ minHeap.peek());
                } else {
                    System.out.println("Median "+ maxHeap.peek());
                }
            }
        }
    }
}
