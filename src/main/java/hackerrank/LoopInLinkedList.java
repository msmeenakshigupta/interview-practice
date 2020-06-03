package HackerRank;

import java.util.HashSet;

import static java.lang.System.exit;

/**
 * created by megupta on 10/3/19
 */
public class LoopInLinkedList {

    static Node head;

    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    //insert at end of list
    static public void push(int new_data)
    {
        Node new_node = new Node(new_data);
        if(head==null)
            head = new_node;
        else if(head.next ==null)
            head.next = new_node;
        else{
           Node node = head;
           while(node.next!=null)
               node = node.next;
           node.next = new_node;
        }

    }

    //insert at front of list
    static public void pushFront(int new_data)
    {
        Node new_node = new Node(new_data);

        /*  Make next of new Node as head */
        new_node.next = head;

        /*  Move the head to point to new Node */
        head = new_node;
    }


    static public void print(Node h){
        int counter = 1;
        System.out.print(h.data);
        while (h.next!=null){
            System.out.print("-->");
            h = h.next;
            System.out.print(h.data);
            counter++;
            if(counter>6)
                break;
        }
    }

    static boolean detectLoopUsingSet(Node h){
        HashSet<Node> nodeHashSet = new HashSet<>();
        System.out.print(h.data);
        while (h!=null){
            if(nodeHashSet.contains(h))
                return true;

            nodeHashSet.add(h);
            h=h.next;
            System.out.print("-->");
            System.out.print(h.data);

        }
        return false;
    }

    static int detectAndRemoveLoop(Node h){
        Node slow = h; Node fast = h;
        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                System.out.println("Loop found, removing....");
                removeLoop(slow, h);
                return  1;
            }
        }
        System.out.println("No Loop");
        return 0;
    }

    static public void removeLoop(Node slow, Node h){
        System.out.println("...removing loop");
        //find number of nodes in loop
        int k=1;
        Node ptr1 = slow.next;
        while(ptr1!=slow){
            k++;
            ptr1 = ptr1.next;
        }

        ptr1 = head;
        Node ptr2 = head;
        for(int i=0; i<k; i++){
            ptr1 = ptr1.next;
        }
        for(int i=0; i<k; i++){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        while(ptr2.next!=ptr1){
            ptr2 = ptr2.next;
        }
        ptr2.next = null;

    }

    public static void main(String[] args)
    {
        LoopInLinkedList llist = new LoopInLinkedList();

        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(10);

        /*Create loop for testing */
        llist.head.next.next.next.next = llist.head;

        print(head);

//        if (detectLoopUsingSet(llist.head))
//            System.out.println("Loop found");
//        else
//            System.out.println("No Loop");
        detectAndRemoveLoop(llist.head);

        print(llist.head);
    }
}
