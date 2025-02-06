package Tree.DFS;

import java.util.*;


public class preOrderDFS {
    class TreeNode<E>{
        E data;
        TreeNode left;
        TreeNode right;
        public TreeNode(E data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String[] args) {
        
    }
    // ---Iterative Approch
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add((Integer) node.data);
            
            // First add right in this approch due to stack than left
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return list;
    }

    // ---Recursive Approch
    // public void preOrder(TreeNode root, ArrayList<Integer> list){
    //     if(root==null) return;
    //     list.add((Integer)root.data);
    //     preOrder(root.left, list);
    //     preOrder(root.right, list);
    // }
}
