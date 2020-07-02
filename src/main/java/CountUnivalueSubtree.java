/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count =0;
    public int countUnivalSubtrees(TreeNode root) {
         if (root == null) return 0;
        is_uni(root);
        return count;
    }
    
    boolean is_uni(TreeNode node){
        if(node.left==null && node.right==null){
            count++;
            return true;
        }
        boolean is_unival = true;
        if(node.left!=null){
            is_unival = is_uni(node.left) && is_unival && node.left.val == node.val;
        }
        if(node.right!=null){
            is_unival = is_uni(node.right) && is_unival && node.right.val == node.val;
        }
        if(!is_unival) return false;
        count++;
        return true;
            
    }
}
