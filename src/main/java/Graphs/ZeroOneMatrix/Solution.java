package Graphs.ZeroOneMatrix;

import java.util.LinkedList;
import java.util.Queue;

// ***********************************************************************

/**
 * Optimal Solution using BFS -
 * <p>
 * Time Complexity - O(m * n), as each cell is processed at most once.
 * Space Complexity - O(m * n), the space for the queue in the worst case when all cells have '0'.
 */
public class Solution {
    private final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }

        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] distances = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    distances[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            for (int[] dir : DIRECTIONS) {
                int r = x + dir[0];
                int c = y + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n && distances[r][c] > distances[x][y] + 1) {
                    queue.add(new int[]{r, c});
                    distances[r][c] = distances[x][y] + 1;
                }
            }
        }

        return distances;
    }

}

// *********************************************************************************
/**
 * Brute Force Solution -
 * <p>
 * Time Complexity - O(m^2 * n^2), where m and n are dimensions of the matrix. This is because for each '1', we are traversing the entire matrix.
 * Space Complexity - O(m * n) for the result matrix.
 */
class Solution_Brute_Force {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    res[i][j] = getMinDistance(matrix, i, j);
                }
            }
        }
        return res;
    }

    private int getMinDistance(int[][] matrix, int x, int y) {
        int m = matrix.length, n = matrix[0].length;
        int minDistance = m * n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    minDistance = Math.min(minDistance, Math.abs(i - x) + Math.abs(j - y));
                }
            }
        }
        return minDistance;
    }
}
