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
    
         int mx = Integer.MAX_VALUE;
    int mi = Integer.MIN_VALUE;
    public int largestBSTSubtree(TreeNode root) {
        int[] ans = dfs(root);
        return ans[2];
    }
    private int[] dfs(TreeNode root){
        if (root == null)
            return new int[]{mx, mi, 0};
        int[] lTree = dfs(root.left);
        int[] rTree = dfs(root.right);
        if (lTree[1] < root.val && root.val < rTree[0]){
            return new int[]{Math.min(lTree[0], root.val), Math.max(rTree[1], root.val), lTree[2] + rTree[2] + 1};
        }
        return new int[]{mi, mx, Math.max(lTree[2], rTree[2])};
    
    }
}
