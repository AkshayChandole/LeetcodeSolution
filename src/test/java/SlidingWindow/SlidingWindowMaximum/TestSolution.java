package SlidingWindow.SlidingWindowMaximum;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestSolution {
    @Test
    public void TestCase1() {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] expectedResult = new int[]{3,3,5,5,6,7};
        evaluateSolution(nums, k, expectedResult);
    }

    @Test
    public void TestCase2() {
        int[] nums = new int[]{1};
        int k = 1;
        int[] expectedResult = new int[]{1};
        evaluateSolution(nums, k, expectedResult);
    }

    private void evaluateSolution(int[] nums, int k, int[] expectedResult) {
        Solution solution = new Solution();
        int[] actualResult = solution.maxSlidingWindow(nums, k);
        assertArrayEquals(expectedResult, actualResult);
    }
}
