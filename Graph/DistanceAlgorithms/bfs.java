package Graph.DistanceAlgorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

// the bfs algo is only used when the distance is constant on all nodes or on every level
// else rest three algos are used for finding shortestPath 

public class bfs {
    public static void main(String[] args) {
        
    }

    // gfg
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int V = adj.size();
        int[] dist = new int[V];
        Arrays.fill(dist, -1);
        dist[src] = 0;
    
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(src);
    
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int nei : adj.get(node)) {
                if (dist[nei] == -1) {
                    dist[nei] = dist[node] + 1;
                    q.offer(nei);
                }
            }
        }
        return dist;
    }
}
