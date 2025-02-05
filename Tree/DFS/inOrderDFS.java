package Tree.DFS;

import java.util.*;
public class inOrderDFS {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                list.add((Integer)node.data);
                node = node.right;
            }
        }
    return list;
   }

    // ---Recursive Approch
    // public void inOrder(TreeNode root, ArrayList<Integer> list){
    //     if(root==null) return;
    //     inOrder(root.left, list);
    //     list.add((Integer)root.data);
    //     inOrder(root.right, list);
    // }
}
