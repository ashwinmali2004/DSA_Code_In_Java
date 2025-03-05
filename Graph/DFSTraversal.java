package Graph;

import java.util.ArrayList;

public class DFSTraversal {
    // GFG Depth of Graph
    
        // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int V = adj.size();
        boolean visited[] = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<visited.length;i++){
            if(!(visited[i])){
                dfs(i, visited, adj, res);
            }
        }
        return res;
    }
    
    public void dfs(int node, boolean visited[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res){
        visited[node] = true;
        res.add(node);
        for(int neighbour : adj.get(node)){
            if(!(visited[neighbour])){
                dfs(neighbour, visited, adj, res);
            }
        }
    }
}
