Stack<Integer> seen;
    public boolean checkEqualTree(TreeNode root) {
        seen = new Stack<>();
        int total = sum(root);
        seen.pop();
        
        if(total % 2 == 0){
            //iterator stack
            for(int s:seen){
                // System.out.println(s);
                if(s == total / 2)
                    return true;
            }
        }
        return false;

    }
    public int sum(TreeNode node){
        if(node == null) return 0;
        seen.push(node.val + sum(node.left) + sum(node.right));
        // System.out.println(seen.peek());
        return seen.peek();
    }
