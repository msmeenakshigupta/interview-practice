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
    List<Integer> ans;
    public List<Integer> getLonelyNodes(TreeNode root) {
        ans = new ArrayList();
        if(root==null)
            return ans;
        traverse(root);
        return ans;
    }
    public void traverse(TreeNode node){
        if(node.left!=null && node.right==null){
            ans.add(node.left.val);
            traverse(node.left);
        }
        else if(node.left==null && node.right!=null){
            ans.add(node.right.val);
            traverse(node.right);
        }
        else if (node.left!=null && node.right!=null){
            traverse(node.left);
            traverse(node.right);
        }
        return;
    }
}
