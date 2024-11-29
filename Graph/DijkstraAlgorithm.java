package Graph;
import java.io.*;
import java.util.*;
import java.lang.*;

public class DijkstraAlgorithm {
    public int minDistance(int[] dist,Boolean sptSet[], int n){
        int min = Integer.MAX_VALUE, min_index=-1;
        for(int v=0;v<n;v++){
            if(sptSet[v]==false && dist[v]<=min){
                min=dist[v];
                min_index=v;
            }
        }
        return min_index; 
    }
    void printSolution(int dist[],int n)
    {
        System.out.println(
            "Vertex \t\t Distance from Source");
        for (int i = 0; i < n; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }
    public void dijkstra(int graph[][], int src, int n){
        int dist[] = new int[n];
        Boolean sptSet[] = new Boolean[n];

        for(int i=0;i<n;i++){
            dist[i]=Integer.MAX_VALUE;
            sptSet[i]=false;
        }

        dist[src]=0;
        for(int count=0;count<n-1;count++){
            int u = minDistance(dist, sptSet, n);
            sptSet[u]=true;
            for(int v=0;v<n;v++){
                if(!sptSet[v] && graph[u][v]!=0 && dist[u] != Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]){
                    dist[v]=dist[u]+graph[u][v];
                }
            }
        }
        printSolution(dist, n);
    }
    public static void main(String[] args) {
        int graph[][]
        = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                        { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                        { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                        { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                        { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                        { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                        { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                        { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                        { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
    DijkstraAlgorithm t = new DijkstraAlgorithm();
    t.dijkstra(graph, 0, 9);
    }
}
