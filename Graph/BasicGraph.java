package Graph;

import java.util.*;

public class BasicGraph {
    int adjMatrix[][];
    
    BasicGraph(int nodes){
        adjMatrix = new int[nodes][nodes]; //4*4 matrix
    }

    public void addEdgesInMatrix(int edges[][], boolean isDirected){
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            // directed 
            if(isDirected){
                adjMatrix[u][v] = 1;
            }else{
                // undirected
                adjMatrix[u][v] = 1;
                adjMatrix[v][u] = 1;
            }
        }
    }

    public void addEdgesWithWeight(int edges[][], boolean isDirected){
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            // directed 
            if(isDirected){
                adjMatrix[u][v] = w;
            }else{
                // undirected
                adjMatrix[u][v] = w;
                adjMatrix[v][u] = w;
            }
        }
    }

    public void printMatrix(){
        for(int i=0;i<adjMatrix.length;i++){
            for(int j=0;j<adjMatrix[i].length;j++){
                System.out.print(adjMatrix[i][j]+",");
            }
            System.out.println();
        }
    }

    public void findDegreeInUnDirectedGraph(int edges[][], int nodes){
        int degree[] = new int[nodes];
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            degree[u]++;
            degree[v]++;
        }

        // print
        for(int i=0;i<nodes;i++){
            System.out.println("node -> "+i+" degree -> "+degree[i]);
        }
    }

    public void findDegreeInDirectedGraph(int edges[][], int nodes){
        int inDegree[] = new int[nodes];
        int outDegree[] = new int[nodes];
        for(int edge[] : edges){
            int from = edge[0];
            int to = edge[1];
            inDegree[to]++;
            outDegree[from]++;
        }

        // print
        for(int i=0;i<nodes;i++){
            System.out.println("node -> "+i+" inDegree -> "+ inDegree[i]);
            System.out.println("node -> "+i+" outDegree -> "+ outDegree[i]);
        }
    }

    public static void main(String[] args) {
        int edges[][] = {{0,2}, {0,1}, {1,3}};
        int nodes = 4;
        BasicGraph graph = new BasicGraph(nodes);
        // System.out.println("Directed Graph ->");
        // graph.addEdgesInMatrix(edges, true);
        // graph.printMatrix();
        // System.out.println("Undirected Graph ->");
        // graph.addEdgesInMatrix(edges, false);
        // graph.printMatrix();

        int edgesWeight[][] = {{0,2,10}, {0,1,20}, {1,3,30}};
        System.out.println("Weighted Directed Graph ->");
        graph.addEdgesWithWeight(edgesWeight, true);
        graph.printMatrix();
        System.out.println("Weighted Undirected Graph ->");
        graph.addEdgesWithWeight(edgesWeight, false);
        graph.printMatrix();

        graph.findDegreeInUnDirectedGraph(edges,4);
        graph.findDegreeInDirectedGraph(edges,4);

    }
}
