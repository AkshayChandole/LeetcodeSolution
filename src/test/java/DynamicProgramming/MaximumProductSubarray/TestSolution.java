package DynamicProgramming.MaximumProductSubarray;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    /*
    Input: nums = [2,3,-2,4]
    Output: 6
     */
    @Test
    public void TestCase1() {
        int[] nums = {2, 3, -2, 4};
        int expectedResult = 6;

        evaluateSolution(nums, expectedResult);
    }

    /*
    Input: nums = [-2,0,-1]
    Output: 0
     */
    @Test
    public void TestCase2() {
        int[] nums = {-2, 0, -1};
        int expectedResult = 0;

        evaluateSolution(nums, expectedResult);
    }

    private void evaluateSolution(int[] nums, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.maxProduct(nums);

        assertEquals(expectedResult, actualResult);
    }
}
