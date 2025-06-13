package Graph.DistanceAlgorithms;

// to find the shortest path from everynode to everyothernode
// multisource shortest path algorithm
// It can detect negative cycle
// Easiest to code and understand
// uses dynamic programming

public class FloyadWarshall {
    public void floydWarshall(int[][] dist) {
        // Code here
        int V = dist.length;
        int INF = 100000000; // or Integer.MAX_VALUE, depending on your input

        for (int via = 0; via < V; via++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][via] < INF && dist[via][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                    }
                }
            }
        }
    }

    // negative cycle detection
        public void shortest_distance(int[][] matrix)
    {
        // Code here 
        // matrix[i][j] == -1 no path to infinity
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j] = 1001; //check the contraints and assign acc.
                }
            }
        }
        //O(N^3)
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j] = Math.min(matrix[i][j] , matrix[i][k] + matrix[k][j]);
                }
            }
        }
        //detecting a negative cycle 
        for(int i=0;i<n;i++){
            if(matrix[i][i]<0){
                System.out.println("negative cycle detected");
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1001){
                    matrix[i][j] = -1; //check the contraints and assign acc.
                }
            }
        }
    }
}

// Q  on LeetCode - 2976