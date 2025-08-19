package Graph.DistanceAlgorithms;
import java.io.*;
import java.util.*;
import java.lang.*;

// This alhorithm works for the positive value distance only!
// single source shortest path algorithm
// Worked in directed as well as undirected graph
// It does not work in negative weight graph
// It is a type of greedy algorithm

public class DijkstraAlgorithm {
    public int[] dijkstra(int V, int[][] edges, int src) {
        
        // you can use pair or 3ArrayList[u]
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            
            ArrayList<Integer> temp1 = new ArrayList<>();
            temp1.add(v); temp1.add(w);
            adj.get(u).add(temp1);
            
            ArrayList<Integer> temp2 = new ArrayList<>();
            temp2.add(u); temp2.add(w);
            adj.get(v).add(temp2);
        }

        // Step 2: Run Dijkstra's algorithm
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > dist[u]) continue;

            for (ArrayList<Integer> neighbor : adj.get(u)) {
                int v = neighbor.get(0);
                int w = neighbor.get(1);
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        return dist;
    }
}

// Q743
