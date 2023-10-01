package Graphs.GraphValidTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Brute force solution using BFS -
 * <p>
 * Time Complexity - O(n + e) where n is the number of nodes and e is the number of edges, because each node and edge is visited once.
 * Space Complexity - O(n + e) due to the storage of the graph and the visited array.
 */
public class Solution {
    /**
     * @param n     an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (visited[node]) {
                return false;   // This means there is a cycle.
            }

            visited[node] = true;

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);

                    // Remove the reverse direction to ensure no double counting in undirected graph
                    adj.get(neighbor).remove((Integer) node);
                }
            }
        }

        // Ensure that the graph is connected
        for (boolean isVisitedNode : visited) {
            if (!isVisitedNode) {
                return false;
            }
        }

        return true;
    }
}


/**
 * Brute force solution using DFS -
 * <p>
 * Time Complexity - O(n + e) where n is the number of nodes and e is the number of edges, because each node and edge is visited once.
 * Space Complexity - O(n + e) due to the storage of the graph and the visited array.
 */
class Solution_DFS {
    /**
     * @param n     an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        // Ensure that the graph does not contain cycle
        if (hasCycle(-1, 0, adj, visited)) {
            return false;
        }

        // Ensure that the graph is connected
        for (boolean isVisitedNode : visited) {
            if (!isVisitedNode) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int parent, int node, List<List<Integer>> adj, boolean[] visited) {

        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycle(node, neighbor, adj, visited)) ;
            } else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }
}
