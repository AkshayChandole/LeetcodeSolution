package Graphs.RottingOranges;

import java.util.ArrayDeque;
import java.util.Queue;

// ****************************************************************************************
// Optimal Solution using Breast first search -

/**
 * Time Complexity - O(M * N) where M and N are the dimensions of the grid. Each cell is processed once.
 * Space Complexity - O(M * N) for the queue in the worst case.
 */
class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        int freshCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // if no fresh oranges to rot
        if (freshCount == 0) {
            return 0;
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int minutes = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();

                for (int[] dir : directions) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];

                    if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] != 1) {
                        continue;
                    }

                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                    freshCount--;
                }
            }

            // increase the minutes for each level
            if (!queue.isEmpty()) {
                minutes++;
            }
        }

        return freshCount == 0 ? minutes : -1;
    }
}
