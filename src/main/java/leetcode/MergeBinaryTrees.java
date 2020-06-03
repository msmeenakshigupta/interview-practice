
/**
 * created by megupta on 05/05/20
 */
public class MergeBinaryTrees {

    public static void main(String[] args) {


        BinaryTreeOperations.TreeNode left1 = new BinaryTreeOperations.TreeNode(5);
        BinaryTreeOperations.TreeNode left = new BinaryTreeOperations.TreeNode(3, left1, null);
        BinaryTreeOperations.TreeNode right = new BinaryTreeOperations.TreeNode(2);
        BinaryTreeOperations.TreeNode t1 = new BinaryTreeOperations.TreeNode(1, left, right);

        System.out.println( BinaryTreeOperations.levelOrder(t1));

        BinaryTreeOperations.TreeNode right2 = new BinaryTreeOperations.TreeNode(4);
        BinaryTreeOperations.TreeNode leftt = new BinaryTreeOperations.TreeNode(1, null, right2);
        BinaryTreeOperations.TreeNode right1 = new BinaryTreeOperations.TreeNode(7);
        BinaryTreeOperations.TreeNode rightt = new BinaryTreeOperations.TreeNode(3, null, right1);
        BinaryTreeOperations.TreeNode t2 = new BinaryTreeOperations.TreeNode(2, leftt, rightt);

        System.out.println( BinaryTreeOperations.levelOrder(t2));

        System.out.println(BinaryTreeOperations.mergeTrees(t1, t2));

    }







}
