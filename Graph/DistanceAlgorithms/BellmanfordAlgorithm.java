package Graph.DistanceAlgorithms;

import java.util.Arrays;

// single source shortest path.
// can detect negative cycles
// works on directed graph

public class BellmanfordAlgorithm {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int dist[] = new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;

        // Step 1: Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (dist[u] != (int)1e8 && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Step 2: Check for negative-weight cycles
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if (dist[u] != (int)1e8 && dist[u] + w < dist[v]) {
                return new int[]{-1};
            }
        }

        return dist;
    }
}

// Q787
