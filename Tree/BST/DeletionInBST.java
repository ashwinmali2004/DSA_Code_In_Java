package Tree.BST;

import org.w3c.dom.Node;

class DeletionInBST {
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
        DeletionInBST obj=new DeletionInBST();
        // obj.deleteNode(null, 0)
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;    
        }

        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            // If the node is the leaf node
            if(root.left == null && root.right == null){
                root = null;
                return null;
            }

            // If child is one
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                // If two child or root node->(Inorder predecesor or successor)
                // TreeNode node = inorderSucccessor(root.right);
                TreeNode node = inorderPredecesor(root.left);
                root.val = node.val;
                root.left = deleteNode(root.left , node.val);
            }
        }
        return root;
    }
    // to find the biggest value from LST
    public TreeNode inorderPredecesor(TreeNode root){
        while(root.right != null){
            root = root.right;
        }
        return root;
    }

    // You can use InorderPredecesor or InorderSuccessor
    // to find the smallest value from BST
    public TreeNode inorderSucccessor(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}