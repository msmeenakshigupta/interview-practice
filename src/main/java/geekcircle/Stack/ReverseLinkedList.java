package com.geekcircle.Stack;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-07-26
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.ListNode;

import java.util.Stack;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = null;
        ListNode prev = head;
        for (int i = 0; i < 5; i++){
            ListNode newNode = new ListNode(i+1, null);
            if(head == null){
                head = newNode;
            } else {
                prev.next = newNode;
            }
            prev = newNode;
        }

        head = reverse(head);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }

        //reverseLinkedList(head);
    }

    private static ListNode reverseLinkedList(ListNode listNode){
        //Fill elements in Stack
        if(listNode == null){
            return null;
        }
        Stack<ListNode> stack = new Stack();
        while(listNode != null){
            stack.add(listNode);
            listNode = listNode.next;
        }

        ListNode newHead = null;
        ListNode prev = null;
        while (!stack.isEmpty()) {
            ListNode poppedNode = stack.pop();
            poppedNode.next = null;
            if(newHead == null){
                newHead = poppedNode;
            } else {
                prev.next = poppedNode;
            }
            prev = poppedNode;
        }
        while (newHead != null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
        return newHead;
    }

    private static ListNode reverse(ListNode node){
        if(node.next == null){
            return node;
        }

        ListNode t = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return t;
    }

}
