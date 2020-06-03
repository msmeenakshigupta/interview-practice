package HackerRank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * created by megupta on 5/13/19
 */
class TreeNode{
    TreeNode left,right;
    int data;
    TreeNode(int data){
        this.data=data;
        left=right=null;
    }
}


public class BinarySearchTree {
    static final int COUNT = 10;
    public static int getHeight(TreeNode root){
        int height = 0;
        if(root!=null && (root.left!=null || root.right!=null)){
            height++;
            int leftHeight = root.left!=null ? getHeight(root.left): 0;
            int rightHeight = root.right!=null ? getHeight(root.right): 0;
            if(leftHeight>rightHeight)
                height+= leftHeight;
            else
                height+= rightHeight;
        }
        return height;
    }

    static void levelOrder(TreeNode root){

        if(root!=null)
            System.out.print(root.data);
        List<TreeNode> children  = new ArrayList<>();
        if(root.left!=null)
            children.add(root.left);
        if(root.right!=null)
            children.add(root.right);
        printChildren(children);

    }

    private static void printChildren(List<TreeNode> nodes) {
        if(nodes.size()>0){
            List<TreeNode> children = new ArrayList<>();
            for(TreeNode node: nodes){
                System.out.print(" "+node.data);
                if(node.left!=null)
                    children.add(node.left);
                if(node.right!=null)
                    children.add(node.right);
            }
            printChildren(children);

        }

    }


    public static TreeNode insert(TreeNode root,int data){
        if(root==null){
            return new TreeNode(data);
        }
        else{
            TreeNode cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    static void print2DUtil(TreeNode root, int space)
    {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.data + "\n");

        // Process left child
        print2DUtil(root.left, space);
    }

    // Wrapper over print2DUtil()
    static void print2D(TreeNode root)
    {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        TreeNode root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        int height=getHeight(root);
        System.out.println(height);
        print2D(root);
        levelOrder(root);
    }
}
