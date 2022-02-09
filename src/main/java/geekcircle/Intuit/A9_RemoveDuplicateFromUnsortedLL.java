package com.geekcircle.Intuit;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-25
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.ListNode;

import java.util.HashSet;
import java.util.Set;

public class A9_RemoveDuplicateFromUnsortedLL {
    public static void main(String[] args) {
        int[] arr = {2,2,2,2,1,5,2};
        ListNode head = null;
        ListNode prev = null;
        for(int i = 0; i < arr.length; i++){
            if(head == null){
                head = new ListNode(arr[i]);
                prev = head;
            } else {
                prev.next = new ListNode(arr[i]);
                prev = prev.next;
            }
        }

        approach1(head);
    }

    private static void approach1(ListNode head){
        ListNode temp = head;
        Set<Integer> set = new HashSet<>();
        while (temp != null){
            set.add(temp.val);
            if(temp.next != null && set.contains(temp.next.val)){
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        temp = head;
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
