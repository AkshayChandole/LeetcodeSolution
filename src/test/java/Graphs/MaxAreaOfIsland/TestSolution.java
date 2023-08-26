package Graphs.MaxAreaOfIsland;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    /*
    Example 1:
    Input: grid = [
        [0,0,1,0,0,0,0,1,0,0,0,0,0],
        [0,0,0,0,0,0,0,1,1,1,0,0,0],
        [0,1,1,0,1,0,0,0,0,0,0,0,0],
        [0,1,0,0,1,1,0,0,1,0,1,0,0],
        [0,1,0,0,1,1,0,0,1,1,1,0,0],
        [0,0,0,0,0,0,0,0,0,0,1,0,0],
        [0,0,0,0,0,0,0,1,1,1,0,0,0],
        [0,0,0,0,0,0,0,1,1,0,0,0,0]
    ]
    Output: 6
     */
    @Test
    public void TestCase1() {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int expectedResult = 6;

        evaluateSolution(grid, expectedResult);
    }

    /*
    Example 2:
        Input: grid = [[0,0,0,0,0,0,0,0]]
        Output: 0
     */
    @Test
    public void TestCase2() {
        int[][] grid = {{0, 0, 0, 0, 0, 0, 0, 0}};
        int expectedResult = 0;

        evaluateSolution(grid, expectedResult);
    }

    private void evaluateSolution(int[][] grid, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.maxAreaOfIsland(grid);

        assertEquals(expectedResult, actualResult);
    }
}
