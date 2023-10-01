package Graphs.NumberOfConnectedComponentsInAnUndirectedGraph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Example 1:
        Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
        Output: 2
     */
    @Test
    public void TestCase1() {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        int expectedResult = 2;

        evaluateSolution(n, edges, expectedResult);
    }

    /*
    Example 2:
        Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
        Output:  1
     */
    @Test
    public void TestCase2() {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int expectedResult = 1;

        evaluateSolution(n, edges, expectedResult);
    }

    private void evaluateSolution(int n, int[][] edges, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.countComponents(n, edges);

        assertEquals(expectedResult, actualResult);
    }
}
