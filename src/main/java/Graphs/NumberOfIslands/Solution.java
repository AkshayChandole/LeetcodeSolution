package Graphs.NumberOfIslands;

// *******************************************************************************************
// Optimal Solution using depth first search (DFS) -

/**
 * Time Complexity - O(M * N), where M and N are the dimensions of the grid. In the worst case, we might need to visit all cells.
 * Space Complexity - O(M * N) in the worst case due to the recursion stack (when the grid is filled with land).
 */
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numberOfIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // if it is a land -
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    numberOfIslands++;
                }
            }
        }

        return numberOfIslands;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        // Mark the cell as visited
        grid[i][j] = '0';

        dfs(grid, i + 1, j);    // down
        dfs(grid, i - 1, j);    // up
        dfs(grid, i, j + 1);    // right
        dfs(grid, i, j - 1);    // lef
    }
}
