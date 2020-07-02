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
    
    public ListNode plusOne(ListNode head) {
        int c = dfs(head);
        if(c>0){
            ListNode nextH = new ListNode(c, head);
            return nextH;
        }
        return head;
    }
    public int dfs(ListNode node){
        int carry =0;
        if(node.next==null){
            int val = node.val+1;
            if(val>9){
                carry = val/10;
                val = val%10;       
            }
            node.val = val;
            return carry;
        }
         int val =  node.val+dfs(node.next);
        if(val>9){
            carry = val/10;
            val = val%10;       
        }
        node.val = val;
        return carry;
    }
}
