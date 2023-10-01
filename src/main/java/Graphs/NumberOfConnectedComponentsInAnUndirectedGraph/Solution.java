package Graphs.NumberOfConnectedComponentsInAnUndirectedGraph;

import java.util.ArrayList;
import java.util.List;

/*
 * Brute force solution using DFS -
 *
 * Time Complexity - The time complexity for this approach is O(n + e), where n is the number of nodes and e is the number of edges, because each node and edge is visited once.
 *
 * Space Complexity - The space complexity is O(n + e), to store the graph and the visited information.
 */
public class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = 0;

        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] a : edges) {
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(adj, visited, i);
            }
        }
        return count;
    }

    private void dfs(List<List<Integer>> adj, boolean[] visited, int i) {
        if (visited[i]) {
            return;
        }

        visited[i] = true;

        for (int j = 0; j < adj.get(i).size(); j++) {
            dfs(adj, visited, adj.get(i).get(j));
        }
    }
}
