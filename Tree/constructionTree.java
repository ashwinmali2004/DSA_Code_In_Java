package Tree;

import java.util.HashMap;

public class constructionTree {
    class TreeNode<E>{
        E data;
        TreeNode left;
        TreeNode right;
        TreeNode(E data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        constructionTree obj = new constructionTree();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        System.out.println(obj.buildTree(preorder, inorder));
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            indexMap.put(inorder[i],i);
        }
        int m = preorder.length-1;
        int n = inorder.length-1;
        TreeNode root = constructTree(preorder, inorder, indexMap, 0, m, 0, n);
        return root;
    }

    public TreeNode constructTree(int[] preorder, int[] inorder, HashMap<Integer, Integer> indexMap, int preIndStart, int preIndEnd, int inIndStart, int inIndEnd){
        // handle base case
        if(preIndStart>preIndEnd || inIndStart>inIndEnd){
            return null;
        }

        int rootData = preorder[preIndStart];
        int rootIndex = indexMap.get(rootData);
        TreeNode root = new TreeNode(rootData);

        int leftTreeSize = rootIndex - inIndStart; 
        int rightTreeSize = inIndEnd - rootIndex;

        root.left = constructTree(preorder, inorder, indexMap, preIndStart + 1, preIndStart + leftTreeSize, inIndStart, rootIndex - 1);
        root.right = constructTree(preorder, inorder, indexMap, preIndStart + leftTreeSize + 1, preIndStart+leftTreeSize+rightTreeSize, rootIndex + 1, inIndEnd);

        return root;
    }
}
