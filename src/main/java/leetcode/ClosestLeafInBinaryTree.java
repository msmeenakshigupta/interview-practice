class Solution {
    public int findClosestLeaf(TreeNode root, int k) {
       TreeNode node = getNode(root, k);
        Map<TreeNode, TreeNode> parentChildMap = new HashMap<>();
        buildParentChildMap(root, parentChildMap);
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(node);
        visited.add(node.val);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                
                if (isLeaf(current)) {
                    return current.val;
                }
                
                if (isAValidNode(current.left, visited)) {
                    queue.offer(current.left);
                    visited.add(current.left.val);
                }
                
                if (isAValidNode(current.right, visited)) {
                    queue.offer(current.right);
                    visited.add(current.right.val);
                }
                
                if (parentChildMap.containsKey(current)) {
                    TreeNode parent = parentChildMap.get(current);
                    if (isAValidNode(parent, visited)) {
                        queue.offer(parent);
                        visited.add(parent.val);
                    }
                }
            }
        }
        
        return -1;
    }
    
    boolean isAValidNode(TreeNode node, Set<Integer> visited) {
        return node != null && !visited.contains(node.val);
    }
    
    void buildParentChildMap(TreeNode node, Map<TreeNode, TreeNode> parentChildMap) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            parentChildMap.put(node.left, node);
            buildParentChildMap(node.left, parentChildMap);
        }
        if (node.right != null) {
            parentChildMap.put(node.right, node);
            buildParentChildMap(node.right, parentChildMap);
        }
    }
    
    TreeNode getNode(TreeNode node, int k) {
        if (node == null) {
            return null;
        }
        if (node.val == k) {
            return node;
        }
        TreeNode left = getNode(node.left, k);
        return left != null ? left : getNode(node.right, k);
    }
    
    boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
