package Backtracking.Permutations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    /*
    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    @Test
    public void TestCase1() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> expectedResult = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(1, 2, 3)), new ArrayList<>(Arrays.asList(1, 3, 2)), new ArrayList<>(Arrays.asList(2, 1, 3)), new ArrayList<>(Arrays.asList(2, 3, 1)), new ArrayList<>(Arrays.asList(3, 1, 2)), new ArrayList<>(Arrays.asList(3, 2, 1))));

        evaluateSolution(nums, expectedResult);
    }

    /*
    Input: nums = [0,1]
    Output: [[0,1],[1,0]]
     */
    @Test
    public void TestCase2() {
        int[] nums = new int[]{0, 1};
        List<List<Integer>> expectedResult = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(0, 1)), new ArrayList<>(Arrays.asList(1, 0))));

        evaluateSolution(nums, expectedResult);
    }

    /*
    Input: nums = [1]
    Output: [[1]]
     */
    @Test
    public void TestCase3() {
        int[] nums = new int[]{1};
        List<List<Integer>> expectedResult = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(1))));

        evaluateSolution(nums, expectedResult);
    }

    private void evaluateSolution(int[] nums, List<List<Integer>> expectedResult) {
        Solution solution = new Solution();
        List<List<Integer>> actualResult = solution.permute(nums);

        assertEquals(expectedResult, actualResult);
    }
}
