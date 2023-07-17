package ArraysAndHashing.ReversePairs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    @Test
    public void TestCase1() {
        int[] nums = new int[]{1, 3, 2, 3, 1};
        int expectedResult = 2;
        evaluateSolution(nums, expectedResult);
    }

    @Test
    public void TestCase2() {
        int[] nums = new int[]{2, 4, 3, 5, 1};
        int expectedResult = 3;
        evaluateSolution(nums, expectedResult);
    }

    private void evaluateSolution(int[] nums, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.reversePairs(nums);
        assertEquals(expectedResult, actualResult);
    }
}
