package Graphs.MaxAreaOfIsland;

// ***************************************************************
// Optimal Solution using depth first search (DFS) -

/**
 * Time Complexity - O(M * N), where M and N are the dimensions of the grid. In the worst case, we might need to visit all cells.
 * Space Complexity - O(M * N), in the worst case due to the recursion stack (when the grid is filled with land).
 */
public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        // Mark the cell as visited
        grid[i][j] = 0;

        int area = 1;

        area += dfs(grid, i + 1, j);    // down
        area += dfs(grid, i - 1, j);    // up
        area += dfs(grid, i, j + 1);    // right
        area += dfs(grid, i, j - 1);    // left

        return area;
    }


}
