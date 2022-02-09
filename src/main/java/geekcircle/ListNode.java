package com.geekcircle;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-26
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() { }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}