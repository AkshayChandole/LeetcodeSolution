package TwoPointers.ThreeSum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    @Test
    public void TestCase1() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(Arrays.asList(-1, -1, 2));
        expectedResult.add(Arrays.asList(-1, 0, 1));
        evaluateSolution(nums, expectedResult);
    }

    @Test
    public void TestCase2() {
        int[] nums = new int[]{0, 1, 1};
        List<List<Integer>> expectedResult = new ArrayList<>();
        evaluateSolution(nums, expectedResult);
    }

    @Test
    public void TestCase3() {
        int[] nums = new int[]{0, 0, 0};
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(Arrays.asList(0, 0, 0));
        evaluateSolution(nums, expectedResult);
    }

    private void evaluateSolution(int[] nums, List<List<Integer>> expectedResult) {
        Solution solution = new Solution();
        List<List<Integer>> actualResult = solution.threeSum(nums);
        assertEquals(expectedResult, actualResult);
    }
}
