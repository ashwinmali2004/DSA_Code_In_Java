package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetection {
    public static void main(String[] args) {

    }

    // Through BFS-Undirected Graph

    public boolean checkIfCycle(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { src, -1 });
        visited[src] = true; // Mark the source as visited

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int node = pair[0];
            int parent = pair[1];

            for (int neighbour : adj.get(node)) {
                if (neighbour == parent)
                    continue;
                if (visited[neighbour])
                    return true; // Cycle detected
                queue.offer(new int[] { neighbour, node });
                visited[neighbour] = true; // Mark neighbour as visited when added to queue
            }
        }
        return false;
    }

    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && checkIfCycle(i, adj, visited)) {
                return true;
            }
        }
        return false;
    }

    // DFS-Undierced Graph
    public boolean checkIfCycle(int src,int parent ,ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[src] = true;
        for(int neighbour : adj.get(src)){
            if(neighbour == parent) continue;
            if(visited[neighbour]){
                return true;
            }else{
                if(checkIfCycle(neighbour, src, adj, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && checkIfCycle(i, -1,adj, visited)) {
                return true;
            }
        }
        return false;
    }

    // Cycle-detection In directed Graph
    public boolean dfs(int src, boolean visited[], ArrayList<ArrayList<Integer>> adj, boolean pathVisited[]){
        visited[src]=true;
        pathVisited[src]=true;
        for(int neighbour : adj.get(src)){
            if(pathVisited[neighbour]){
                return true;
            }else if(visited[neighbour]){
                continue;
            }else{
                if(dfs(neighbour, visited, adj, pathVisited)){
                    return true;
                }
            }
        }
        pathVisited[src]=false;
        return false;
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(i, visited, adj, pathVisited)){
                    return true;
                }
            }
        }
        return false;
    }

    
}
