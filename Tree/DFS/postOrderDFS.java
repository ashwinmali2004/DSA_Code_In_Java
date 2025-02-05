package Tree.DFS;

import java.util.*;
public class postOrderDFS {
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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node!=null || !stack.isEmpty()){
            // move to the left
            while(node!=null){
                stack.push(node);
                node = node.left;
            }
            // move to the right
            if(stack.peek().right!=null){
                node=stack.peek().right;
            }else{
                TreeNode temp = stack.pop();
                list.add((Integer)temp.data);
                while(!stack.isEmpty() && temp==stack.peek().right){
                    temp=stack.pop();
                    list.add((Integer)temp.data);
                }
            }
        }
    return list;
    }

    // ---Recursive Approch
    // public void postOrder(TreeNode root, ArrayList<Integer> list){
    //     if(root==null) return;
    //     postOrder(root.left, list);
    //     postOrder(root.right, list);
    //     list.add((Integer)root.data);
    // }
}
