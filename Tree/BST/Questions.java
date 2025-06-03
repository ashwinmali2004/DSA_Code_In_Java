package Tree.BST;

import java.util.*;

public class Questions {
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
        
    }
    //Q-653 leetcode
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        
        // two pointer approch
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    //Q 98
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean validate(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }
        if(root.val<=min || root.val>=max){
            return false;
        }
        boolean left = validate(root.left, min, root.val);
        boolean right = validate(root.right, root.val, max);

        return (left && right);
    }

    // 230
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k-1);
    }

    public void inorder(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    // 235 LCA in BST
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    // 1373 LeetCode Maximum Sum BST in Binary Tree
    // ----->check vaid BST + Do the sum (and return the Maximum Sum from BST's)
    int ans;
    public int maxSumBST(TreeNode root){
        ans = 0;
        dfs(root);
        return ans;
    }

    public int[] dfs(TreeNode root){
        if(root==null){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int leftSubtree[] = dfs(root.left);
        int rightSubtree[] = dfs(root.right);
        // if valid BST
        if(root.val>leftSubtree[1] && root.val<rightSubtree[0]){
            int curSum = leftSubtree[2]+root.val+rightSubtree[2];
            ans = Math.max(ans, curSum);
            int minVal = Math.max(root.val, leftSubtree[0]);
            int maxVal = Math.max(root.val, rightSubtree[1]);
            return new int[] {minVal, maxVal, curSum};
        }
        // if Not Valid BST
        int maxSum = Math.max(leftSubtree[2],rightSubtree[2]);
        return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, maxSum};
    }
}
