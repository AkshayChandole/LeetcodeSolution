package Graphs.ZeroOneMatrix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /**
     * Example 1:
     * Input: matrix = [[0,0,0],[0,1,0],[0,0,0]]
     * Output: [[0,0,0],[0,1,0],[0,0,0]]
     */
    @Test
    public void TestCase1() {
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] expectedResult = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

        evaluateSolution(matrix, expectedResult);
    }

    /**
     * Example 2:
     * Input: matrix = [[0,0,0],[0,1,0],[1,1,1]]
     * Output: [[0,0,0],[0,1,0],[1,2,1]]
     */
    @Test
    public void TestCase2() {
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] expectedResult = {{0, 0, 0}, {0, 1, 0}, {1, 2, 1}};

        evaluateSolution(matrix, expectedResult);
    }

    private void evaluateSolution(int[][] matrix, int[][] expectedResult) {
        Solution solution = new Solution();
        int[][] actualResult = solution.updateMatrix(matrix);

        assertEquals(expectedResult, actualResult);
    }
}
