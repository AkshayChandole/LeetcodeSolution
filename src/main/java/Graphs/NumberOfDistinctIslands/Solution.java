package Graphs.NumberOfDistinctIslands;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Optimal Solution using DFS -
 *
 * Time Complexity - O(n * m)
 * Space Complexity - O(n * m)
 */
public class Solution {

    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();

        // traverse the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // if not visited and is a land cell
                if (!visited[i][j] && grid[i][j] == 1) {
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i, j, grid, visited, list, i, j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }

    private void dfs(int row, int col, int[][] grid, boolean[][] visited, ArrayList<String> list, int row0, int col0) {
        int n = grid.length;
        int m = grid[0].length;

        visited[row][col] = true;

        list.add(toString(row - row0, col - col0));

        for (int[] dir : DIRECTIONS) {
            int nrow = row + dir[0];
            int ncol = col + dir[1];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !visited[nrow][ncol] && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, grid, visited, list, row0, col0);
            }
        }
    }

    private String toString(int row, int col) {
        return Integer.toString(row) + " " + Integer.toString(col);
    }


}
