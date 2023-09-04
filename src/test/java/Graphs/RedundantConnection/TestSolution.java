package Graphs.RedundantConnection;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestSolution {
    /*
    Example 1:
        Input: edges = [[1,2],[1,3],[2,3]]
        Output: [2,3]
     */
    @Test
    public void TestCase1() {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        int[] expectedResult = {2, 3};

        evaluateSolution(edges, expectedResult);
    }

    /*
    Example 2:
        Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
        Output: [1,4]
     */
    @Test
    public void TestCase2() {
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[] expectedResult = {1, 4};

        evaluateSolution(edges, expectedResult);
    }

    private void evaluateSolution(int[][] edges, int[] expectedResult) {
        Solution solution = new Solution();
        var actualResult = solution.findRedundantConnection(edges);

        assertArrayEquals(expectedResult, actualResult);
    }
}
