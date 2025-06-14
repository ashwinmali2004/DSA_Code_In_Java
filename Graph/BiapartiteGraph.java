package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class BiapartiteGraph {
    public static void main(String[] args) {
        
    }
    
    /*A biapartite is a graph in which the vertices can be divided into two
     * disjoint sets, such that no two vertices within the same set are adjacent.
    */

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        Arrays.fill(color, -1);
        for(int i=0;i<n;i++){
            if(color[i] == -1){
                if(!color(i, graph, color)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean color(int src, int graph[][], int color[]){
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        color[src]=0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int neighbour : graph[node]){
                if(color[neighbour] == -1){
                    color[neighbour] = 1-color[node];
                    q.offer(neighbour);
                }else if(color[neighbour] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}
