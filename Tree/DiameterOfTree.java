package Tree;

import java.util.*;

class TreeNode<E>{
    E data;
    TreeNode left;
    TreeNode right;
    TreeNode children;
    public TreeNode(E data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.children = null;
    }
}
public class DiameterOfTree{
    public static void main(String[] args) {
        
    }
    // LeetCode 543 
    // O(n)  In worst case O(log2(n))->this complexity when all are filled in a tree
    public int diameterOfBinaryTree(TreeNode root) {
        int maxi[] = {0}; // call by reference in java
        findHeight(root, maxi);
        return maxi[0];
    }
    public int findHeight(TreeNode root, int maxi[]){
        if(root == null) return 0;
        int left = findHeight(root.left, maxi);
        int right = findHeight(root.right, maxi);
        maxi[0] = Math.max(maxi[0],(left+right));
        return Math.max(left, right)+1;
    }

    // 1522 LeetCode FaceBook
    // For n-array 

    public int findHeightNArray(TreeNode root, int maxi[]){
        if(root == null) return 0;
        int h1=0;
        int h2=0;
        int h=0;
        for(TreeNode node : root.children){
            h = findHeightNArray(node, maxi);
            if(h>h1){
                h2=h1;
                h1=h;
            }else if(h>h2){
                h2=h;
            }
        }
        maxi[0] = Math.max(maxi[0],(h1+h2));
        return (1+h1);
    }

}