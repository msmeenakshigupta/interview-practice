package com.geekcircle.Top100;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-26
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.PriorityQueue;

public class A30_KthLargest {

    public static void main(String[] args) {
        int[] arr = {7, 4, 6, 3, 9, 1};
        //1,3,4,6,7,9
        int k = 2;
        System.out.println(kthLargestElement(arr, k));
    }

    static int kthLargestElement(int[] arr, int k){
        //For kth Largest Min Heap and vice versa
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            pq.add(arr[i]);
        }

        // do for remaining array elements
        for (int i = k; i < arr.length; i++)
        {
            // if current element is less than the root of the heap
            if (arr[i] > pq.peek())
            {
                // replace root with the current element
                pq.poll();
                pq.add(arr[i]);
            }
        }

        // return the root of max-heap
        return pq.peek();

    }
}