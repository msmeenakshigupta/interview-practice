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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        res.add(root.val);  
        if(root.left ==null && root.right==null){
            return res;
        }
        
        leftBoundary(root.left, res);
        leafBoundary(root, res);
        List<Integer> rev =new ArrayList<>();
        rightBoundary(root.right, rev);
        Collections.reverse(rev);
        res.addAll(rev);
        return res;
    }
    
    private void leftBoundary(TreeNode node, List<Integer> res){
        if(node!=null){
            if(node.left!=null){
                res.add(node.val);
                leftBoundary(node.left, res);
            }else if(node.right!=null){
                res.add(node.val);
                leftBoundary(node.right, res);
            }
        }
    }
    
    private void leafBoundary(TreeNode node, List<Integer> res){
        if(node!=null){
            leafBoundary(node.left, res);
            if(node.left==null && node.right==null){
                res.add(node.val);
            }
            leafBoundary(node.right, res);
        }
    }
    private void rightBoundary(TreeNode node, List<Integer> res){
        if(node!=null){
            if(node.right!=null){
                res.add(node.val);
                rightBoundary(node.right, res);
            }else if(node.left!=null){
                res.add(node.val);
                rightBoundary(node.left, res);
            }
        }
    }
}  
