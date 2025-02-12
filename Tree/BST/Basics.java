package Tree.BST;

import Tree.DFS.inOrderDFS;

public class Basics {
    public class TreeNode {
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
        Basics b = new Basics();
        int[] a = {4,2,7,1,3};
        TreeNode root = b.constructBST(a);
        b.inOrderDFS(root);
        // System.out.println(b.searchBST(root, 4));  // It will return the address of the Tree
        // System.out.println(b.searchBST(root, 6));
    }

    // Searching in BST
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){ 
            return null;
        }
        if(val<root.val){
            return searchBST(root.left, val);
        }else if(val>root.val){
            return searchBST(root.right, val);
        }else{
            return root;
        }
    }

    // Inorder Traversal
    public void inOrderDFS(TreeNode root){
        if(root == null) return;
        inOrderDFS(root.left);
        System.out.print(root.val + " ");
        inOrderDFS(root.right);
    }

    // construction of BST
    public TreeNode constructBST(int arr[]){
        TreeNode root = null;
        for(int i=0;i<arr.length;i++){
            root = insertIntoBST(root, arr[i]);
        }
        return root;
    }
    
    // Recursive Approch-->
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            root = new TreeNode(val);
            return root;
        }
        if(val<root.val){
            root.left = insertIntoBST(root.left, val);
        }else{
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
    
        // Insertion --> 701 Leetcode
        // public TreeNode insertIntoBST(TreeNode root, int val) {
        //     if(root == null){
        //         root = new TreeNode(val);
        //         return root;
        //     }
        //     TreeNode temp = root;
        //     while(temp!=null){
        //         if(val<temp.val){
        //             if(temp.left == null){
        //                 temp.left = new TreeNode(val);
        //                 break;
        //             }else{
        //                 temp = temp.left;
        //             }
        //         }else{
        //             if(temp.right == null){
        //                 temp.right = new TreeNode(val);
        //                 break;
        //             }else{
        //                 temp = temp.right;
        //             }
        //         }
        //     }
        //     return root;
        // }
}
