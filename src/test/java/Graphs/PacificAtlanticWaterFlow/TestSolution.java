package Graphs.PacificAtlanticWaterFlow;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    /*
    Example 1:
        Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
        Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
     */
    @Test
    public void TestCase1() {
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        List<List<Integer>> expectedResult = new ArrayList<>(Arrays.asList(Arrays.asList(0, 4), Arrays.asList(1, 3), Arrays.asList(1, 4), Arrays.asList(2, 2), Arrays.asList(3, 0), Arrays.asList(3, 1), Arrays.asList(4, 0)));

        evaluateSolution(heights, expectedResult);
    }

    /*
    Example 2:
        Input: heights = [[1]]
        Output: [[0,0]]
     */
    @Test
    public void TestCase2() {
        int[][] heights = {{1}};
        List<List<Integer>> expectedResult = new ArrayList<>(Arrays.asList(Arrays.asList(0, 0)));

        evaluateSolution(heights, expectedResult);
    }

    private static void evaluateSolution(int[][] heights, List<List<Integer>> expectedResult) {
        Solution solution = new Solution();
        List<List<Integer>> actualResult = solution.pacificAtlantic(heights);

        assertEquals(expectedResult, actualResult);
    }

}
