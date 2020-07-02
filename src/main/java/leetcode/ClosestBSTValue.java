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
    double min_diff= Double.MAX_VALUE;
    int ans=0;
    public int closestValue(TreeNode root, double target) {
        if(root!=null){
            double diff = Math.abs((double)root.val - target);
            if(min_diff>diff){
                min_diff=diff;
                ans = root.val;
            }
            closestValue(root.left, target);
            closestValue(root.right, target);
        }
        return ans;
            
    }
}
