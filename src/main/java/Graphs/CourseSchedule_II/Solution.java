package Graphs.CourseSchedule_II;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// **************************************************************
// Optimal Solution using topological sort and breadth first search (BFS) -

/**
 * Time Complexity - O(N + E), where N is the number of courses, and E is the number of prerequisites. We process each node and edge once.
 * Space Complexity - O(N + E) for storing the graph and other additional data structures like the BFS queue.
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];

        // We will count the incoming edges for a node and store it in inDegree array.
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] pair : prerequisites) {
            graph[pair[1]].add(pair[0]);
            inDegree[pair[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int index = 0;
        int[] result = new int[numCourses];

        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[index++] = course;

            for (int neighbor : graph[course]) {
                if (--inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Return the result if all courses are added
        if (index == numCourses) {
            return result;
        }

        // Return empty array if not all courses can be taken
        return new int[0];

    }
}


// *******************************************************************
// Brute force solution using depth first search (DFS) -

/**
 * Time Complexity - O(N^2) in the worst case. Since for each node, we might need to traverse nearly the entire graph.
 * Space Complexity - O(N + E), where E is the number of prerequisites. This is for the adjacency list representation and the DFS traversal stack.
 */
class Solution1 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create an adjacency list representation of the graph
        List<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] pair : prerequisites) {
            graph[pair[1]].add(pair[0]);
        }

        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && dfs(i, graph, visited, path, result)) {
                // Cycle detected --> return empty array
                return new int[0];
            }
        }

        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = result.get(numCourses - 1 - i);
        }

        return order;
    }

    private boolean dfs(int node, List<Integer>[] graph, boolean[] visited, boolean[] path, List<Integer> result) {
        if (path[node]) {
            // cycle detected --> return true
            return true;
        }

        if (visited[node]) {
            // already process, no cycle found from this node
            return false;
        }

        visited[node] = true;
        path[node] = true;

        for (int neighbor : graph[node]) {
            if (dfs(neighbor, graph, visited, path, result)) {
                return true;
            }
        }

        path[node] = false;
        result.add(node);
        return false;
    }
}
