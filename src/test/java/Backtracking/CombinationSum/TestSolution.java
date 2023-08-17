package Backtracking.CombinationSum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: candidates = [2,3,6,7], target = 7
    Output: [[2,2,3],[7]]
     */
    @Test
    public void TestCase1() {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> expectedResult = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(2, 2, 3)), new ArrayList<>(Arrays.asList(7))));

        evaluateSolution(candidates, target, expectedResult);
    }

    /*
    Input: candidates = [2,3,5], target = 8
    Output: [[2,2,2,2],[2,3,3],[3,5]]
     */
    @Test
    public void TestCase2() {
        int[] candidates = new int[]{2, 3, 5};
        int target = 8;
        List<List<Integer>> expectedResult = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(2, 2, 2, 2)), new ArrayList<>(Arrays.asList(2, 3, 3)), new ArrayList<>(Arrays.asList(3, 5))));

        evaluateSolution(candidates, target, expectedResult);
    }

    /*
    Input: candidates = [2], target = 1
    Output: []
     */
    @Test
    public void TestCase3() {
        int[] candidates = new int[]{2};
        int target = 1;
        List<List<Integer>> expectedResult = new ArrayList<>();

        evaluateSolution(candidates, target, expectedResult);
    }

    private void evaluateSolution(int[] candidates, int target, List<List<Integer>> expectedResult) {
        Solution solution = new Solution();
        List<List<Integer>> actualResult = solution.combinationSum(candidates, target);

        assertEquals(expectedResult, actualResult);
    }
}
