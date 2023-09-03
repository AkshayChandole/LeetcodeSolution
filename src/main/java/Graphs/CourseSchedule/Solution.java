package Graphs.CourseSchedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// **********************************************************
// Optimal Solution using topological-sort and depth first search (DFS) -
/*
Algorithm (Topological Sort):
   * Graph Representation:
        Represent the course prerequisite relationship as a directed graph. The courses are the nodes and the edges represent a course being a prerequisite for another.
        Create an adjacency list representation of this graph and also compute the in-degrees (number of incoming edges) for each course/node.
   * Khan's Algorithm:
        Find all nodes with in-degree 0 (no prerequisites) and add them to a queue.
        While the queue is not empty, remove a node, and:
            Increment a count of finished courses.
            For each neighbor (i.e., courses that had the current node as a prerequisite), decrease their in-degree by 1.
            If a neighbor's in-degree becomes 0 (all prerequisites are met), add it to the queue.
        Once the queue is empty, check if the count of finished courses is equal to the total number of courses. If so, it's possible to finish all courses.
*/

/**
 * Time Complexity - O(N + E), where N is the number of courses, and E is the number of prerequisites.
 * Space Complexity - O(N + E) to store the graph and for the data structures used in topological sorting.
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        int count = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;

            for (int neighbor : graph[course]) {
                if (--inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return count == numCourses;
    }
}


// **************************************************************************
// Brute Force Solution using Depth First Search (DFS) -

/*
 * Time Complexity - O(N^2), where N is the number of courses. In the worst case, we might have to start DFS from each node and traverse nearly the entire graph
 * Space Complexity - O(N + E) where E is the number of prerequisites, as we'll store the graph in an adjacency list and also use space for the DFS stack.
 */
class Solution1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] pair : prerequisites) {
            graph[pair[0]].add(pair[1]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(graph, visited, stack, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(List<Integer>[] graph, boolean[] visited, boolean[] stack, int course) {
        if (stack[course]) {
            return true;
        }

        if (visited[course]) {
            return false;
        }

        visited[course] = true;
        stack[course] = true;

        for (int neighbor : graph[course]) {
            if (hasCycle(graph, visited, stack, neighbor)) {
                return true;
            }
        }

        stack[course] = false;
        return false;
    }
}