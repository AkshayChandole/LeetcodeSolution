package DynamicProgramming.LongestIncreasingSubsequence;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    /*
    Input: nums = [10,9,2,5,3,7,101,18]
    Output: 4
     */
    @Test
    public void TestCase1() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int expectedResult = 4;

        evaluateSolution(nums, expectedResult);
    }

    /*
    Input: nums = [0,1,0,3,2,3]
    Output: 4
     */
    @Test
    public void TestCase2() {
        int[] nums = {0, 1, 0, 3, 2, 3};
        int expectedResult = 4;

        evaluateSolution(nums, expectedResult);
    }

    /*
    Input: nums = [7,7,7,7,7,7,7]
    Output: 1
     */
    @Test
    public void TestCase3() {
        int[] nums = {7, 7, 7, 7, 7, 7, 7};
        int expectedResult = 1;

        evaluateSolution(nums, expectedResult);
    }

    private void evaluateSolution(int[] nums, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.lengthOfLIS(nums);

        assertEquals(expectedResult, actualResult);
    }
}
