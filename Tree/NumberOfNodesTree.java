package Tree;

import java.util.*;
public class NumberOfNodesTree {
    class Node<E>{
        E data;
        Node left;
        Node right;
        Node(E data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String[] args) {
        
    }
        public static int findLeftHegiht(Node root){
        if(root == null) return 0;
        int left = 1;
        while(root.left!=null){
            left++;
            root = root.left;
        }
        return left;
    }
    
    public static int findRightHegiht(Node root){
        if(root == null) return 0;
        int right = 1;
        while(root.right!=null){
            right++;
            root = root.right;
        }
        return right;
    }

    public static int countNodes(Node root) {
        // Code here
        if(root == null) return 0;
        // DFS only three lines
        // O(n)
        // int l = countNodes(root.left);
        // int r = countNodes(root.right);
        // return 1+l+r;
        
        // O(log2n)2  <  O(n)
        int leftHeight = findLeftHegiht(root);
        int rightHeight = findRightHegiht(root);
        if(leftHeight == rightHeight){
            return ((int)Math.pow(2, leftHeight)-1);
        }
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
