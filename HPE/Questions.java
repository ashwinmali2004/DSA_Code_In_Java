package HPE;
import java.util.*;

public class Questions {
    // Q1 find the Subsequence of Even Difference
    public static int findLongestSubsequence(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr); // sort the array

        // The key insight: The sum of adjacent differences of a sorted subsequence
        // is just max - min of that subsequence!
        // So for the full array, sum = arr[n-1] - arr[0]
        // If (arr[n-1] - arr[0]) is even, use the full array

        if ((arr[n-1] - arr[0]) % 2 == 0) {
            return n;
        }

        // Otherwise, try removing one element from start or end
        // and check if that makes the difference even.
        // (Because removing any other element doesn't change min or max)

        if ((arr[n-2] - arr[0]) % 2 == 0 || (arr[n-1] - arr[1]) % 2 == 0) {
            return n - 1;
        }

        // Otherwise, longest possible is n-2 (rare case)
        return n - 2;
    }

    // Q2 DP+GRAPH
    static int[] weight;
    static List<List<Integer>> adj; // adjacency list
    static int[][] dp; // dp[node][0]: max if not taken, dp[node][1]: max if taken

    // DFS returns nothing - fills dp for each node.
    static void dfs(int node, int parent) {
        dp[node][1] = weight[node]; // take node
        dp[node][0] = 0;            // don't take node

        for (int child : adj.get(node)) {
            if (child == parent) continue; // skip parent

            dfs(child, node);

            dp[node][0] += Math.max(dp[child][0], dp[child][1]); // choose best for children
            dp[node][1] += dp[child][0];  // take node, can't take children
        }
    }

    // Main function to solve the problem
    // nodes: number of tree nodes
    // tree_from, tree_to: edges
    // w: weights
    public static int solve(int nodes, int[] tree_from, int[] tree_to, int[] w) {
        weight = w;
        adj = new ArrayList<>();
        for (int i = 0; i < nodes; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < tree_from.length; i++) {
            // Make 0-based
            int u = tree_from[i] - 1;
            int v = tree_to[i] - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dp = new int[nodes][2];
        dfs(0, -1); // root is node 0
        return Math.max(dp[0][0], dp[0][1]); // answer is best at root
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 7};
        int[] arr2 = {7,5,6,2,3,2,4};
        System.out.println(findLongestSubsequence(arr));// 4
        System.out.println(findLongestSubsequence(arr2));// 6


        // Example 1:
        int nodes1 = 3;
        int[] from1 = {1, 1};
        int[] to1 = {2, 3};
        int[] w1 = {4, 2, 1};
        System.out.println(solve(nodes1, from1, to1, w1)); // Output: 4

        // Example 2:
        int nodes2 = 5;
        int[] from2 = {1, 2, 2, 3};
        int[] to2 = {2, 3, 5, 4};
        int[] w2 = {2, 6, 2, 3, 1};
        System.out.println(solve(nodes2, from2, to2, w2)); // Output: 7
    }    
}
