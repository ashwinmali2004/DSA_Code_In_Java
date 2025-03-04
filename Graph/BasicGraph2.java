package Graph;

import java.util.*;

public class BasicGraph2 {
    // for adding the weight in the adjlist create pair
    class Pair{
        int node;
        int weight;
        Pair(int n, int w){
            node = n;
            weight = w;
        }

        // (node, weight)
        @Override
        public String toString(){
            return "("+node+","+weight+")";
        }
    }

    List<List<Integer>> adjList;
    List<List<Pair>> adjListWithWeight;

    BasicGraph2(int nodes){
        adjList = new ArrayList<>();
        adjListWithWeight = new ArrayList<>();

        for(int i=0;i<nodes;i++){
            adjList.add(new ArrayList<>());
            adjListWithWeight.add(new ArrayList<>());
        }
    }

    public void addEdgesInList(int edges[][], boolean isDirected){
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            // directed 
            if(isDirected){
                adjList.get(u).add(v);
            }else{
                // undirected
                adjList.get(u).add(v);
                adjList.get(v).add(u);

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
                Pair pair = new Pair(v,w);
                adjListWithWeight.get(u).add(pair);
            }else{
                // undirected
                Pair pair1 = new Pair(v,w);
                Pair pair2 = new Pair(u,w);

                adjListWithWeight.get(u).add(pair1);
                adjListWithWeight.get(v).add(pair2);
            }
        }
    }

    public void printList(){
        for(int i=0;i<adjList.size();i++){
            System.out.print(i + " -> ");
            System.out.print("[");
            for(int j=0;j<adjList.get(i).size();j++){
                System.out.print(adjList.get(i).get(j)+",");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public void printWeightedList(){
        for(int i=0;i<adjListWithWeight.size();i++){
            System.out.print(i + " -> ");
            System.out.print("[");
            for(int j=0;j<adjListWithWeight.get(i).size();j++){
                System.out.print(adjListWithWeight.get(i).get(j)+",");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int edges[][] = {{0,2}, {0,1}, {1,3}};
        int nodes = 4;
        BasicGraph2 graph = new BasicGraph2(nodes);
        // System.out.println("Directed Graph ->");
        // graph.addEdgesInList(edges, true);
        // graph.printList();
        // System.out.println("Undirected Graph ->");
        // graph.addEdgesInList(edges, false);
        // graph.printList();

        int edgesWeight[][] = {{0,2,10}, {0,1,20}, {1,3,30}};
        System.out.println("Weighted Directed Graph ->");
        graph.addEdgesWithWeight(edgesWeight, true);
        graph.printWeightedList();
        System.out.println("Weighted Undirected Graph ->");
        graph.addEdgesWithWeight(edgesWeight, false);
        graph.printWeightedList();

    }
}
