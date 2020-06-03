package HackerRank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * created by megupta on 5/13/19
 */
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

public class LinkedListCustom {
    public static  Node insert(Node head,int data)
    {
        Node p=new Node(data);
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            Node start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }

    public static Node removeDuplicates(Node head) {
        //Write your code here
        Set<Integer> values = new HashSet<>();
        Node start = head;
        Node previous = start;
        while(start!=null){
            if(values.contains(start.data)){
                start = start.next;
                previous.next = start;
            }else{
                values.add(start.data);
                previous = start;
                start = start.next;
            }
        }
        return head;

    }

    public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        head=removeDuplicates(head);
        display(head);
        sc.close();
    }
}