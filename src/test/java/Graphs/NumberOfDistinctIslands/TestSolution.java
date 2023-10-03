package Graphs.NumberOfDistinctIslands;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Example 1:
        Input :
            11000
            11000
            00011
            00011
        Output : 1
     */
    @Test
    public void TestCase1() {
        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        int expectedResult = 1;

        evaluateSolution(grid, expectedResult);
    }

    /*
    Example 2:
        Input :
            11011
            10000
            00001
            11011
        Output : 3
     */
    @Test
    public void TestCase2() {
        int[][] grid = {{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 0, 1, 1}};
        int expectedResult = 3;

        evaluateSolution(grid, expectedResult);
    }

    private void evaluateSolution(int[][] grid, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.numDistinctIslands(grid);

        assertEquals(expectedResult, actualResult);
    }
}
