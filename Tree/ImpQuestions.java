package Tree;

import java.util.*;
public class ImpQuestions {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        // TreeNode() {}
        // TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
   }
    public static void main(String[] args) {
        
    }

    /*View All the View Questions of the Tree:
    ->right view, left view, bottom view, boundary view, vertical view.....
    */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new LinkedList<>();
        if(root == null) return res;

        // You can use both LinkedList, ArrayList Exapand (LinkedList will be quiet faster)
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        while(!q.isEmpty()){
            List<Integer> levelList = new LinkedList<>();
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                levelList.add(node.val);
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            if (level % 2 == 0) {
                Collections.reverse(levelList);
            }
            res.add(levelList);
            level++;
        }
        return res;
    }

    //Check Is Tree Balanced
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = height(root.right);
        if (rightHeight == -1) return -1; 

        if (Math.abs(leftHeight - rightHeight) > 1) return -1; 

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 236 *** Lowest Common Ancestor
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode LeftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode RightNode = lowestCommonAncestor(root.right, p, q);

        if(LeftNode == null){
            return RightNode;
        }else if(RightNode == null){
            return LeftNode;
        }else{
            return root;
        }
    }
}
