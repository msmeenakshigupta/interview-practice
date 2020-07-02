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
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        helper(root, root.val, 0);
        return max;
    }
    private void helper(TreeNode node, int val, int cnt) {
        if (node == null) return;
        if (node.val == val) cnt++;
        else cnt = 1;
        max = Math.max(max, cnt);
        helper(node.left, node.val + 1, cnt);
        helper(node.right, node.val + 1, cnt);
    }
}
