package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ToposortAlgorithm {

    // bfs toposort
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // Adjecency List..
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        // Find Indegree Array..
        int[] indegree = new int[V];
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        
        // Add zero value nodes..
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        
        // Now start visit until the queue is empty..
        ArrayList<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            res.add(node);
            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    queue.offer(neighbour);
                }
            }
        }
        
        return res;
    }

    // dfs toposort
        public static ArrayList<Integer> topoSortdfs(int V, int[][] edges) {
        // Adjecency List..
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }

        ArrayList<Integer> res = new ArrayList<>();
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i, adj, visited, stack);
            }
        }
        
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        
        return res;
    }

    public static void dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack){
        visited[src] = true;
        for(int neighbour : adj.get(src)){
            if(!visited[neighbour]){
                dfs(neighbour,adj, visited, stack);
            }
        }
        stack.push(src);
    }
}
