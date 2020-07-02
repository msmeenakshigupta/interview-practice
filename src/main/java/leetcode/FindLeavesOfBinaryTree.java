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
   int minHeight = Integer.MAX_VALUE;
    int maxHeight = Integer.MIN_VALUE;
    HashMap<Integer, ArrayList> cache = new HashMap();

    public List<List<Integer>> findLeaves(TreeNode root) {
        height(root);
        List<List<Integer>> res = new ArrayList();

        for(int i=minHeight;i<=maxHeight;i++){
            res.add(cache.get(i));    
        }

        return res;
    }

    public int height(TreeNode root){
        if(root == null)
            return 0;

        int lHeight = height(root.left);
        int rHeight = height(root.right);

        int height = 1 + Math.max(lHeight, rHeight);

        if(!cache.containsKey(height)){
            cache.put(height, new ArrayList());
        }

        ArrayList<Integer> arr = cache.get(height);
        arr.add(root.val);
        cache.put(height, arr);

        if(height<minHeight)
            minHeight = height;

        if(height>maxHeight)
            maxHeight = height;

        return height;
    }
}
