/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        if(head==null || head.next==null) return head;

		ListNode temp=head;
		while(temp!=null){
			int x=m,y=n;
			while(--x>0 && temp!=null){
				temp=temp.next;
			}
			ListNode t=temp;
			if(t==null){
				return head;
			}
			temp=temp.next;
			while(y-->0 && temp!=null){
				temp=temp.next;
			}
			if(t!=null){
				t.next=temp;
				temp=t.next;
			}
		}

		return head;
    }
}
