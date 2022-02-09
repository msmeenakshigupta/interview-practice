package com.geekcircle.Top100;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-31
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.ListNode;

public class MergeTwoSortedLinkedListToOne {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, new ListNode(5, new ListNode(7, new ListNode(9))));
        ListNode head2 = new ListNode(2, new ListNode(4, new ListNode(6, new ListNode(8))));
        ListNode head = mergeTwoLinkedList(head1, head2);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    //1. Save all in list and then sort;
    //2. Read One by one and Save in sort
    static ListNode mergeTwoLinkedList(ListNode head1, ListNode head2){
        ListNode head = null;
        ListNode prev = null;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                if(head == null){
                    head = head1;
                    prev = head;
                } else {
                    prev.next = head1;
                    prev = prev.next;
                }
                head1 = head1.next;
            } else {
                if(head == null){
                    head = head2;
                    prev = head;
                } else {
                    prev.next = head2;
                    prev = prev.next;
                }
                head2 = head2.next;
            }
        }

        if(head1 == null){
            prev.next = head2;
        }

        if(head2 == null){
            prev.next = head1;
        }
        return head;
    }

}
