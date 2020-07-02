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
    PriorityQueue<NodeDis> pq = new PriorityQueue<NodeDis>( 
            (NodeDis a, NodeDis b ) ->  {
                if(a.dis > b.dis)
                    return 1;
                else 
                    return -1;
            });
    
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        
        dfs(root, target);
         List<Integer> res = new ArrayList<>();
        for(int i=0; i<k; i++){
            res.add(pq.poll().val);
        }
        return res;
        
    }
    
    public void dfs(TreeNode node, double target){
        if(node == null)
            return;

        int val = node.val;
        double dis = Math.abs(val - target);
        pq.add(new NodeDis(val, dis));

        dfs(node.left, target);
        dfs(node.right, target);
    }
    
   class NodeDis{
       int val;
       double dis;
       
       public NodeDis(int val, double dis){
           this.val = val;
           this.dis = dis;
       }
   }
        
}
