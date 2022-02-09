package com.geekcircle.Amazon;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-16
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.PriorityQueue;

public class A1_KthLargestElement {
    public static void main(String[] args) {
        int[] arr = {1,23,12,9,30,2,50};
        int k = 2;
        kthLargest(arr, k);
    }

    private static int kthLargest(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            pq.add(arr[i]);
        }

        for(int i = k; i < arr.length; i++){
            if(pq.peek() < arr[i]){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        System.out.println(pq.peek());
        return pq.peek();
    }
}
