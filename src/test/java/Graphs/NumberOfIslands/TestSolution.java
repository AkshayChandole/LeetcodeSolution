package Graphs.NumberOfIslands;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Example 1:
        Input: grid = [
          ["1","1","1","1","0"],
          ["1","1","0","1","0"],
          ["1","1","0","0","0"],
          ["0","0","0","0","0"]
        ]
        Output: 1
     */
    @Test
    public void TestCase1() {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        int expectedResult = 1;

        evaluateSolution(grid, expectedResult);
    }

    /*
    Example 2:
        Input: grid = [
          ["1","1","0","0","0"],
          ["1","1","0","0","0"],
          ["0","0","1","0","0"],
          ["0","0","0","1","1"]
        ]
        Output: 3
     */
    @Test
    public void TestCase2() {
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        int expectedResult = 3;

        evaluateSolution(grid, expectedResult);
    }

    private void evaluateSolution(char[][] grid, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.numIslands(grid);

        assertEquals(expectedResult, actualResult);
    }
}
