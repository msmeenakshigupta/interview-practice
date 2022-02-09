package com.geekcircle.Amazon;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-17
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/


import com.geekcircle.ListNode;

import java.util.Stack;

public class A2_GroupReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8))))))));
        head = reverse(head, 10);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    //Self Solution
    private static ListNode reverse(ListNode head, int k){
        ListNode cur = head;
        ListNode root = null;
        ListNode prev = null;
        int i = 1;
        boolean execute = false;
        Stack<ListNode> stack = new Stack<>();
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
            if(i++%k == 0){
                execute = true;
                while (!stack.isEmpty()){
                    if(root == null){
                        root = stack.pop();
                        prev = root;
                    } else {
                        prev.next = stack.pop();
                        prev = prev.next;
                    }
                }
                prev.next = cur;
            }
        }
        if(execute)
            return root;
        else
            return head;
    }
}
