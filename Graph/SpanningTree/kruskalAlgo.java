package Tree.SpanningTree;

import java.util.*;
public class kruskalAlgo {
    public static void main(String[] args) {
        
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Min heap to store edges by weight
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(int pair1[], int pair2[]){
                return pair1[2] - pair2[2];
            }
        });

        // Add all edges to the priority queue
        boolean visited[][] = new boolean[V][V]; // To avoid duplicate edges
        for (int i = 0; i < V; i++) {
            for (int edges[] : adj.get(i)) {
                int u = i, v = edges[0], weight = edges[1];
                if (!visited[u][v]) { // Ensure each edge is added only once
                    pq.offer(new int[]{u, v, weight});
                    visited[u][v] = visited[v][u] = true;
                }
            }
        }

        DisjointSet dsu = new DisjointSet(V);
        int sum = 0;
        int edgeCount = 0; // Track number of edges in MST

        while (!pq.isEmpty() && edgeCount < V - 1) { // MST has V-1 edges
            int object[] = pq.poll();
            int u = object[0];
            int v = object[1];
            int weight = object[2];

            if (dsu.unionBySize(u, v)) { // If u and v are not in the same set
                sum += weight;
                edgeCount++;
            }
        }
        return sum;
    }
}

class DisjointSet {
    int parent[];
    int size[];

    DisjointSet(int nodes) {
        this.parent = new int[nodes];
        this.size = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    public int findRootParent(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findRootParent(parent[node]); // Path compression
    }

    public boolean unionBySize(int node1, int node2) {
        int rootParent1 = findRootParent(node1);
        int rootParent2 = findRootParent(node2);

        if (rootParent1 == rootParent2) {
            return false;
        }

        if (size[rootParent1] < size[rootParent2]) {
            parent[rootParent1] = rootParent2;
            size[rootParent2] += size[rootParent1];
        } else {
            parent[rootParent2] = rootParent1;
            size[rootParent1] += size[rootParent2];
        }
        return true;
    }

}
