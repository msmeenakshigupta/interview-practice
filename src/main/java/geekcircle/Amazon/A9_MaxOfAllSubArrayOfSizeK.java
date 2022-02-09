package com.geekcircle.Amazon;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-18
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class A9_MaxOfAllSubArrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = {8,5,10,7,9,4,15,12,90,13};
        //int[] arr = {1,2,3,1,4,5,2,3,6};
        //int[] arr = {9,8,7,6,5,4,3,2,1};
        int k = 4;
        //maxOfAllSubArray(arr, k);
        maxOfAllSubArraySol2(arr, k);
    }

    private static void maxOfAllSubArray(int[] arr, int k){
        for(int i = 0; i < arr.length-k+1; i++) {
            int max = 0;
            for(int j = i; j < i+k; j++){
                if(max < arr[j]){
                    max = arr[j];
                }
            }
            System.out.println(max);
        }
    }

    //Using Heap
    private static void maxOfAllSubArraySol2(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
        int j = 0;
        for(int i = 0; i < arr.length; i++){
            if(i < k){
                pq.add(arr[i]);
                continue;
            }
            System.out.println(pq.peek());
            pq.remove(arr[j++]);
            pq.add(arr[i]);
        }
        System.out.println(pq.peek());
    }
}
