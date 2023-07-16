package ArraysAndHashing.TwoSum;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void testCase1() {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] expectedResult = new int[]{0, 1};
        evaluateResult(numbers, target, expectedResult);
    }

    @Test
    public void testCase2() {
        int[] numbers = new int[]{3, 2, 4};
        int target = 6;
        int[] expectedResult = new int[]{1, 2};
        evaluateResult(numbers, target, expectedResult);
    }

    @Test
    public void testCase3() {
        int[] numbers = new int[]{3, 3};
        int target = 6;
        int[] expectedResult = new int[]{0, 1};
        evaluateResult(numbers, target, expectedResult);
    }

    private void evaluateResult(int[] nums, int target, int[] expectedResult) {
        int[] actualResult = solution.twoSum(nums, target);
        assertArrayEquals(expectedResult, actualResult);
    }
}
