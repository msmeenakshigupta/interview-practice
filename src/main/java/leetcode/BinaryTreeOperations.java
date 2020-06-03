import java.util.*;

/**
 * created by megupta on 03/05/20
 */
public class BinaryTreeOperations {

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public static void main(String[] args) {
        TreeNode left3 = new TreeNode(6);
        TreeNode left2 = new TreeNode(5, left3, null);
        TreeNode left = new TreeNode(4, left2, null);

        TreeNode right3 = new TreeNode(6);
        TreeNode right2 = new TreeNode(5, null, right3);
        TreeNode right = new TreeNode(4, null, right2);

        TreeNode root = new TreeNode(3, left, right);


        System.out.println(levelOrder(root));
    }


    public static boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        else if(root.left!=null && root.right!=null)
        {
            TreeNode[] nextLevelArr =  {root.left, root.right};
            return isPalindromeNextLevel(nextLevelArr);

        }
        else if(root.left==null && root.right==null)
        {
            return true;
        }
        return false;
    }
    public static boolean isPalindromeNextLevel(TreeNode[] nextLevelArr){
        if(isPalindrome(nextLevelArr)){
            int newLength = nextLevelArr.length*2;
            TreeNode[] nextLevel = new TreeNode[newLength];
            int index=0;
            int nullCount =0;
            for(int i=0; i<nextLevelArr.length; i++){
                if(nextLevelArr[i]!=null){
                    if(nextLevelArr[i].left==null)
                        nullCount++;
                    if(nextLevelArr[i].right==null)
                        nullCount++;
                    nextLevel[index] = nextLevelArr[i].left;
                    index++;
                    nextLevel[index] = nextLevelArr[i].right;
                    index++;
                }
            }
            TreeNode[] actualNext ;
            if(index<newLength){
                actualNext = new TreeNode[index];
                for(int i=0; i<index; i++){
                    actualNext[i] = nextLevel[i];
                }
            }else{
                actualNext = nextLevel;
            }

            if(nullCount==index)
                return true;
            else
                return isPalindromeNextLevel(actualNext);
        }else{
            return false;
        }

    }

    public static boolean isPalindrome(TreeNode[] nextLevelArr){
        if(nextLevelArr.length>0){
            int i=0;
            int j=nextLevelArr.length-1;
            for(;i<j; i++, j--){
                if(nextLevelArr[i]!=null && nextLevelArr[j]!=null){
                    if(nextLevelArr[i].val!=nextLevelArr[j].val){
                        return false;
                    }
                }else{
                    if(nextLevelArr[i]==null && nextLevelArr[j]==null);
                    else
                        return false;
                }

            }
            return true;
        }else{
            return true;
        }
    }



    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root ==null)
            return list;
        else{
            List<Integer> rootVal = new ArrayList<Integer>();
            rootVal.add(root.val);
            list.add(rootVal);
            TreeNode[] nodeList = {root.left, root.right};
            return nextLevel(nodeList, list);

        }
    }

    public static List<List<Integer>> nextLevel(TreeNode[] nodeList, List<List<Integer>> resultList){
        //if any non-null exists in nodeList
        int nonNullValues = nonNullValues(nodeList);
        if(nonNullValues>0){
            TreeNode[] newNodeList = new TreeNode[nonNullValues*2];
            int index=0;
            List<Integer> thisLevel = new ArrayList<Integer>();
            for(TreeNode node : nodeList){
                if(node!=null){
                    thisLevel.add(node.val);
                    if(node.left!=null){
                        newNodeList[index] = node.left;
                        index++;
                    }
                    if(node.right!=null){
                        newNodeList[index] = node.right;
                        index++;
                    }
                }
            }
            resultList.add(thisLevel);
            return nextLevel(newNodeList, resultList);
        }else{
            return resultList;
        }

    }

    public static int nonNullValues(TreeNode[] nodeList){
        int numValues= 0;
        for(TreeNode node :nodeList){
            if (node!=null){
                numValues++;
            }
        }
        return numValues;
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null)
            return t2;
        if(t2==null)
            return t1;
        TreeNode head = new TreeNode(t1.val+t2.val);
         updateLeft(head, t1, t2);
         updateRight(head, t1, t2);
        return head;
    }

    public static void updateLeft(TreeNode tree, TreeNode t1, TreeNode t2){
        if(t1!=null && t1.left!=null){
            if(t2!=null && t2.left!=null){
                tree.left = new TreeNode(t1.left.val+t2.left.val);
                updateLeft(tree.left, t1.left, t2.left);
                updateRight(tree.left, t1.left, t2.left);
            }else{
                tree.left = new TreeNode(t1.left.val);
                updateLeft(tree.left, t1.left, null);
                updateRight(tree.left, t1.left, null);
            }
        }else if(t2!=null && t2.left!=null){
            tree.left = new TreeNode(t2.left.val);
            updateLeft(tree.left, null, t2.left);
            updateRight(tree.left, null, t2.left);
        }



    }

    public static void updateRight(TreeNode tree, TreeNode t1, TreeNode t2){
        if(t1!=null && t1.right!=null){
            if(t2!=null && t2.right!=null){
                tree.right = new TreeNode(t1.right.val+t2.right.val);
                updateLeft(tree.right, t1.right, t2.right);
                updateRight(tree.right, t1.right, t2.right);
            }else{
                tree.right = new TreeNode(t1.right.val);
                updateLeft(tree.right, t1.right, null);
                updateRight(tree.right, t1.right, null);
            }
        }else if(t2!=null && t2.right!=null){
            tree.right = new TreeNode(t2.right.val);
            updateLeft(tree.right, null, t2.right);
            updateRight(tree.right, null, t2.right);
        }
    }

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

        public boolean isCousins(TreeNode root, int x, int y) {
            if(root==null)
                return false;
            if(root.left!=null && (root.left.val==x || root.left.val==y))
                return false;
            if(root.right!=null && (root.right.val==x || root.right.val==y))
                return false;
            if(root.left!=null || root.right!=null){
                List<TreeNode> nodeAtLevel = new LinkedList<TreeNode>();
                if(root.left!=null)
                    nodeAtLevel.add(root.left);
                if(root.right!=null)
                    nodeAtLevel.add(root.right);
                return findIfCousins(nodeAtLevel, x,y);
            }
            return false;
        }

        public boolean findIfCousins(List<TreeNode> nodesAtLevel, int x, int y){
            List<TreeNode> nodesAtNextLevel = new LinkedList<TreeNode>();
            Map<Integer, Integer> nodeParent = new HashMap<Integer, Integer>();
            for(TreeNode node : nodesAtLevel){
                TreeNode left = node.left;
                TreeNode right = node.right;
                if(left!=null){
                    nodesAtNextLevel.add(left);
                    nodeParent.put(left.val, node.val);
                }
                if(right!=null){
                    nodesAtNextLevel.add(right);
                    nodeParent.put(right.val, node.val);
                }

            }
            Set<Integer> keys = nodeParent.keySet();
            if(keys.contains(x) && keys.contains(y)){
                if(nodeParent.get(x)!=nodeParent.get(y))
                    return true;
                else
                    return false;
            }

            if(!keys.contains(x) && !keys.contains(y) && nodesAtNextLevel.size()>0){
                return findIfCousins(nodesAtNextLevel, x,y);
            }

            return false;
        }

}
