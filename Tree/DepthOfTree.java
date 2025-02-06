package Tree;

import java.util.LinkedList;
import java.util.Queue;

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
// ---> LeetCode -104
public class DepthOfTree {
    public static void main(String[] args) {
    }
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size>0){
                TreeNode node = q.poll();
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
                size--;
            }
            if(!q.isEmpty()){
                level++;
            }
        }
        return (level+1);
    }

    // int res = 0;
    // public int maxDepth(TreeNode root) {
    //     int count = 1;
    //     preOrder(root,count);
    //     return res;
    // }
    // public void preOrder(TreeNode root, int count){
    //     if(root == null){
    //         return;
    //     }
    //     res = Math.max(count, res);
    //     preOrder(root.left, count+1);
    //     preOrder(root.right, count+1);
    // }
}

// ---> Using DFS and BFS Both LeetCode 559
// Depth of n-arrayTree
// public int maxDepth(Node root) {
//     if(root == null) return 0;
//     int maxDepth = 0;
//     for(Node child : root.children){
//         if(child!=null){
//             maxDepth = Math.max(maxDepth, maxDepth(child));
//         }
//     }
//     return maxDepth+1;
// }
// }

// BFS
// public int maxDepth(Node root) {
//     if(root == null) return 0;
//     Queue<Node> queue = new LinkedList<>();
//     int level = 0;
//     queue.offer(root);
//     while(!queue.isEmpty()){
//     int size = queue.size();
//     while(size>0){
//         Node node = queue.poll();
//         for(Node child : node.children){
//             if(child!=null){
//                 queue.offer(child);
//             }
//         }
//         size--;
//     }
//     if(!queue.isEmpty()){
//         level++;
//     }
// }
// return (level+1);
// }