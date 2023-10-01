package Graphs.PacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Optimal Solution using depth-first search (DFS) -
 *
 * Time Complexity - O(m * n), where m is the number of rows and n is the number of columns. Each cell in the matrix is visited at most twice (once for each ocean).
 * Space Complexity - O(m * n) for the DFS traversal stack in the worst case and for storing the two reachable matrices.
 */
public class Solution {
    private static final int[][] DIRECTIONS = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights == null || heights.length == 0 || heights[0].length == 0) {
            return Collections.emptyList();
        }

        int m = heights.length, n = heights[0].length;

        boolean[][] visitedPacific = new boolean[m][n];
        boolean[][] visitedAtlantic = new boolean[m][n];

        for(int i = 0; i < n; i++) {
            // Run DFS for pacific ocean
            dfs(0, i, visitedPacific, heights);

            // Run DFS for atlantic ocean
            dfs(m-1, i, visitedAtlantic, heights);
        }

        for(int i = 0; i < m; i++) {
            // Run DFS for pacific ocean
            dfs(i, 0, visitedPacific, heights);

            // Run DFS for atlantic ocean
            dfs(i, n-1, visitedAtlantic, heights);
        }

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visitedPacific[i][j] && visitedAtlantic[i][j]) {
                    result.add(Arrays.asList(i,j));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, boolean[][] visited, int[][] heights) {
        if(visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        for(int[] dir : DIRECTIONS) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];

            if(newRow < 0 || newRow >= heights.length || newCol < 0 || newCol >= heights[0].length ||
                    heights[newRow][newCol] < heights[r][c]) {
                continue;
            }

            dfs(newRow, newCol, visited, heights);
        }
    }
}