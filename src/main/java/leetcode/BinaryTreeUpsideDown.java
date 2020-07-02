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
   
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null)
             return null;

             TreeNode left_node = upsideDownBinaryTree(root.left);
             TreeNode right_node = upsideDownBinaryTree(root.right);

             if(left_node==null && right_node==null)
                 return root;

             TreeNode temp = left_node;

             while(temp.right!=null)
                 temp=temp.right;

             temp.left = right_node;

             root.left=null;
             root.right=null;
             temp.right = root;

             return left_node;
    }
    
}
