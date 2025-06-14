package Graph;

// DisjointSet-->

// it is used to solve the multiple components quetions in constant time on graph
// O(4*alpha) complexity
// to count the number of nodes in a graph of a component

// 1 find parent() 
// 2 find union() ->by rank ->by size

public class DSU {
    int parent[];
    int rank[];
    int size[];
    int components;
    DSU(int nodes){
        this.parent = new int[nodes];
        this.rank = new int[nodes];
        this.size = new int[nodes];
        this.components = nodes;
        for(int i=0;i<nodes;i++){
            // all are there own parents
            this.parent[i] = i;
            // intialized with rank 0
            this.rank[i] = 0;
            // intialized with size 1
            this.size[i] = 1;
        }
    }

    // find the root function with path compression
    public int findRootParent(int node){
        if(node == parent[node]){
            return node;
        }
        parent[node] = findRootParent(parent[node]);
        return parent[node];
    }

    // union function by using rank[]
    public void unionByRank(int node1, int node2){
        // 1. find the root parent
        int rootParent1 = findRootParent(node1);
        int rootParent2 = findRootParent(node2);

        if(rootParent1 == rootParent2){
            return;
        }
        components--;

        if(rank[rootParent1]<rank[rootParent2]){
            // small component merged into the large component
            parent[rootParent1] = rootParent2;
        }else if(rank[rootParent1]>rank[rootParent2]){
            // small component merged into the large component
            parent[rootParent2] = rootParent1;
        }else{
            // if same value
            // rank will only be increased in this case
            parent[rootParent2] = rootParent1;
            rank[rootParent1]++;
        }
    }

    // union function by using size[]
    // By the help of size[] you can easily calculate the no. of nodes in a component
    public void unionBySize(int node1, int node2){
        // find the root parent
        int rootParent1 = findRootParent(node1);
        int rootParent2 = findRootParent(node2);

        if(rootParent1 == rootParent2){
            return;
        }
        components--;

        // in size case the size will be always be increased
        if (size[rootParent1]<size[rootParent2]) {
            parent[rootParent1] = rootParent2;
            size[rootParent2] += size[rootParent1];
        } else{
            parent[rootParent2] = rootParent1;
            size[rootParent1] += size[rootParent2];
        }
    }

    public static void main(String[] args) {
        // DSU dsu = new DSU(4);
        // System.out.println("total components -> "+ dsu.components);
        // System.out.println(dsu.findRootParent(0) == dsu.findRootParent(3));
        // dsu.unionByRank(0, 3);
        // System.out.println("total components -> "+ dsu.components);
        // System.out.println(dsu.findRootParent(0) == dsu.findRootParent(3));

        DSU dsu = new DSU(4);
        System.out.println("total components -> "+ dsu.components);
        System.out.println(dsu.findRootParent(0) == dsu.findRootParent(3));
        dsu.unionBySize(0, 3);
        System.out.println("total components -> "+ dsu.components);
        System.out.println(dsu.findRootParent(0) == dsu.findRootParent(3));

        // Note:-You cant use DSU of Union by rank and union by size code
    }
}

/*
 * List Of Questions Of DSU
 * Q 684
 * Q 990
 * Q 1319
 * Q 785
*/