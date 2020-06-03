import java.util.Stack;

/**
 * created by megupta on 02/05/20
 */
public class RemoveNthFromEnd {

   static class ListNode {
        int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {

        ListNode node = new ListNode(7);
        ListNode node1 = new ListNode(5, node);
        ListNode head = new ListNode(7, node1);
        printList(head);
//        System.out.println("---------------- remove 2 from last");
//        head = removeNthFromEnd(head, 2);
//        printList(head);

//        System.out.println("---------reverse list---------");
//        head = reverseList(head);
//        printList(head);

//       head = mergeTwoLists(head, head);
//        System.out.println("---------merge lists---------");
//        printList(head);

        System.out.println(isPalindrome(head));

    }

    private static void printList(ListNode head){
        if(head==null){
            return;
        }
        while(head.next!=null){
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println(head.val);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node1 = head;
        ListNode node2 = head;
        for(int i=0; i<n; i++){
            node2 = node2.next;
        }
        if(node2==null){ //delete head
            ListNode nextNode = node1.next;
            if(nextNode==null){
                return null;
            }else{
                head = nextNode;
                return head;
            }

        }else{
            while(node2.next!=null){
                node1 = node1.next;
                node2 = node2.next;
            }

        }

        ListNode nodeToDelete = node1.next;
        if(nodeToDelete.next==null){//delete tail node
            node1.next=null;
        }else{
            ListNode nextNode = nodeToDelete.next;
            nodeToDelete.val = nextNode.val;
            nodeToDelete.next = nextNode.next;
            nextNode = null;
        }

        return head;
    }

    public static ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }else{
            ListNode node = head.next;
            ListNode newHead = reverseList(node);
            return appendToTail(newHead, head);
        }
    }
    public static ListNode appendToTail(ListNode head, ListNode tail){
        ListNode node = head;
        while(node.next!=null){
            node = node.next;
        }
        node.next=tail;
        tail.next =null;
        return head;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dummy.next;

    }

    public static boolean isPalindrome(ListNode head) {
        ListNode curr = head;
        Stack<Integer> stack = new Stack<Integer>();
        while (curr.next!=null){
            stack.push(curr.val);
            curr = curr.next;
        }
        while (head!=null){
            if(head.val != stack.pop()) {
                return false;
            }
                head = head.next;
        }
        return true;


    }
}
