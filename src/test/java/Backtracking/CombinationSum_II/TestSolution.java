package Backtracking.CombinationSum_II;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: candidates = [10,1,2,7,6,1,5], target = 8
    Output:
        [
        [1,1,6],
        [1,2,5],
        [1,7],
        [2,6]
        ]
     */
    @Test
    public void TestCase1() {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> expectedResult = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(1, 1, 6)), new ArrayList<>(Arrays.asList(1, 2, 5)), new ArrayList<>(Arrays.asList(1, 7)), new ArrayList<>(Arrays.asList(2, 6))));

        evaluateSolution(candidates, target, expectedResult);
    }

    /*
    Input: candidates = [2,5,2,1,2], target = 5
    Output:
        [
        [1,2,2],
        [5]
        ]
     */
    @Test
    public void TestCase2() {
        int[] candidates = new int[]{2, 5, 2, 1, 2};
        int target = 5;
        List<List<Integer>> expectedResult = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(1, 2, 2)), new ArrayList<>(Arrays.asList(5))));

        evaluateSolution(candidates, target, expectedResult);
    }

    private void evaluateSolution(int[] candidates, int target, List<List<Integer>> expectedResult) {
        Solution solution = new Solution();
        var actualResult = solution.combinationSum2(candidates, target);

        assertEquals(expectedResult, actualResult);
    }
}
