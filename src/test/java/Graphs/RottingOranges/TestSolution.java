package Graphs.RottingOranges;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    /*
    Example 1:
        Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
        Output: 4
     */
    @Test
    public void TestCase1() {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int expectedResult = 4;

        evaluateSolution(grid, expectedResult);
    }

    /*
    Example 2:
        Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
        Output: -1
     */
    @Test
    public void TestCase2() {
        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int expectedResult = -1;

        evaluateSolution(grid, expectedResult);
    }

    /*
    Example 3:
        Input: grid = [[0,2]]
        Output: 0
     */
    @Test
    public void TestCase3() {
        int[][] grid = {{0, 2}};
        int expectedResult = 0;

        evaluateSolution(grid, expectedResult);
    }

    private void evaluateSolution(int[][] grid, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.orangesRotting(grid);

        assertEquals(expectedResult, actualResult);
    }
}
