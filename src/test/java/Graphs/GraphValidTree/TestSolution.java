package Graphs.GraphValidTree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Example 1:
        Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
        Output: true
     */
    @Test
    public void TestCase1() {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        boolean expectedResult = true;

        evaluateSolution(n, edges, expectedResult);
    }

    /*
    Example 2:
        Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
        Output: false
    */
    @Test
    public void TestCase2() {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        boolean expectedResult = false;

        evaluateSolution(n, edges, expectedResult);
    }

    private void evaluateSolution(int n, int[][] edges, boolean expectedResult) {
        Solution solution = new Solution();
        boolean actualResult = solution.validTree(n, edges);

        assertEquals(expectedResult, actualResult);
    }
}
