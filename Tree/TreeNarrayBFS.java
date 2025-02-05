package Tree;

import java.util.*;

class narrayTreeNode<E>{
    E data;
    ArrayList<narrayTreeNode> children;

    narrayTreeNode(E data){
        this.data = data;
        children = new ArrayList<>();
    }
}
public class TreeNarrayBFS {
    public static void main(String[] args) {
        
    }

    public ArrayList<Integer> BFS(narrayTreeNode<Integer> root){
        if(root==null) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        Queue<narrayTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            narrayTreeNode<Integer> node = queue.poll();
            res.add(node.data);
            for(narrayTreeNode child : node.children){
                if(child!=null){
                    queue.offer(child);
                }
            }
        }
        return res;
    }
}

// 429-leetcode 