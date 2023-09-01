package Graphs.WallsAndGates;

import java.util.LinkedList;
import java.util.Queue;

// ***********************************************************************************************
// Optimal Solution using Breadth First Search (BFS) -

/**
 * Time Complexity - O(M * N) where M and N are the dimensions of the grid. Each cell is processed once.
 * Space Complexity - O(M * N) for the BFS queue in the worst case.
 */
public class Solution {
    private static final int INF = 2147483647;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Add all gates to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // BFS from each gate
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int row = point[0];
            int col = point[1];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || rooms[newRow][newCol] != INF) {
                    continue;
                }

                rooms[newRow][newCol] = rooms[row][col] + 1;
                queue.offer(new int[]{newRow, newCol});
            }
        }
    }
}


// *******************************************************************
// Brute Force Solution using Depth First Search (DFS) -

/**
 * Time Complexity - O(M^2 * N^2) where M and N are the dimensions of the grid. This is because, for each cell with INF, we might need to traverse the entire grid.
 * Space Complexity - O(M * N) for the recursion stack.
 */
class Solution1 {
    private static final int INF = 2147483647;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }

        int m = rooms.length;
        int n = rooms[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == INF) {
                    rooms[i][j] = search(rooms, i, j, m, n);
                }
            }
        }
    }

    private int search(int[][] rooms, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || rooms[i][j] == -1) {
            return INF;
        }

        if (rooms[i][j] == 0) {
            return 0;
        }

        int temp = rooms[i][j];

        // Temporarily mark as wall to avoid cycle
        rooms[i][j] = -1;
        int minDistance = INF;

        for (int[] dir : directions) {
            int distance = search(rooms, i + dir[0], j + dir[1], m, n);
            if (distance != INF) {
                minDistance = Math.min(minDistance, distance + 1);
            }
        }

        // Reset to original value
        rooms[i][j] = temp;

        return minDistance;
    }
}
