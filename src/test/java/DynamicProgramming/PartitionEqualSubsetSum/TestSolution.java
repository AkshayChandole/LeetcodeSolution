package DynamicProgramming.PartitionEqualSubsetSum;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    /*
    Input: nums = [1,5,11,5]
    Output: true
     */
    @Test
    public void TestCase1() {
        int[] nums = {1, 5, 11, 5};
        boolean expectedResult = true;

        evaluateSolution(nums, expectedResult);
    }

    /*
    Input: nums = [1,2,3,5]
    Output: false
     */
    @Test
    public void TestCase2() {
        int[] nums = {1, 2, 3, 5};
        boolean expectedResult = false;

        evaluateSolution(nums, expectedResult);
    }

    private void evaluateSolution(int[] nums, boolean expectedResult) {
        Solution solution = new Solution();
        boolean actualResult = solution.canPartition(nums);

        assertEquals(expectedResult, actualResult);
    }
}
