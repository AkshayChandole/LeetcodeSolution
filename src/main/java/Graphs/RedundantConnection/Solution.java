package Graphs.RedundantConnection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// ***************************************************************************
// Optimal solution using Union-Find approach -
/*
Algorithm:
    Initialization:
        Create a parent array of size N+1 to represent each node and its parent node. Initialize each node's parent as itself.
        Create a rank array of size N+1 to keep track of the depth of trees formed by combining disjoint sets.
    Union-Find Operations:
        As we iterate through the edges, we try to combine (union) the sets that the two nodes of each edge belong to.
        If the two nodes of an edge already belong to the same set (they have the same root or parent), then that edge is the redundant one because adding this edge will form a cycle.
        If they don't belong to the same set, we combine their sets.
    Path Compression:
        When finding the root of a node, we traverse up to the root and update the parent of each node along the path to point directly to the root. This is called path compression and helps in making future find operations faster.
    Union by Rank:
        When combining two sets, we check the rank (tree depth) to determine which set should be attached to the other. The smaller tree should be attached to the larger tree to keep the tree depth minimal. This ensures the time complexity remains efficient.
*/

/**
 * Time Complexity - The time complexity of union and find operations when using union-by-rank and path compression is effectively constant, i.e., O(1). Thus, the time complexity is O(N) where N is the number of edges.
 * Space Complexity - O(N), to store the parent and rank arrays used in Union-Find
 */
class Solution {

    // Union-Find data structure
    int[] parent;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        parent = new int[n + 1];
        rank = new int[n + 1];

        // Initialize parent and rank
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            // if they belong to the same component
            if (connected(a, b)) {
                // this is reduction connection
                return edge;
            } else {
                union(a, b);
            }
        }

        return new int[2];
    }

    // check if x and y are connected
    private boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    // find the path with compression
    private int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    // Union with rank
    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}


// ****************************************************
// Brute force solution using depth first search (DFS) -

/**
 * Time Complexity - O(N^2), where N is the number of vertices. For each edge, we perform a DFS which can take O(N) time in the worst case.
 * Space Complexity - O(N), to store the graph and DFS related data structures.
 */
class Solution1 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = edges.length - 1; i >= 0; i--) {
            int[] edge = edges[i];
            int a = edge[0];
            int b = edge[1];

            // remove the current edge
            graph[a].clear();
            graph[b].clear();

            for (int[] tempEdge : edges) {
                if (tempEdge != edge) {
                    graph[tempEdge[0]].add(tempEdge[1]);
                    graph[tempEdge[1]].add(tempEdge[0]);

                }
            }

            // check the connectivity
            Set<Integer> seen = new HashSet<>();
            dfs(1, graph, seen);

            if (seen.size() == n) {
                return edge;
            }
        }

        return new int[2];
    }


    private void dfs(int node, List<Integer>[] graph, Set<Integer> seen) {
        if (seen.contains(node)) {
            return;
        }

        seen.add(node);

        for (int neighbor : graph[node]) {
            dfs(neighbor, graph, seen);
        }
    }
}