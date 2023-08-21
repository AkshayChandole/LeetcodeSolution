package DynamicProgramming.HouseRobber_II;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: nums = [2,3,2]
    Output: 3
     */
    @Test
    public void TestCase1() {
        int[] nums = {2, 3, 2};
        int expectedResult = 3;

        evalueateSolution(nums, expectedResult);
    }

    /*
    Input: nums = [1,2,3,1]
    Output: 4
     */
    @Test
    public void TestCase2() {
        int[] nums = {1, 2, 3, 1};
        int expectedResult = 4;

        evalueateSolution(nums, expectedResult);
    }

    /*
    Input: nums = [1,2,3]
    Output: 3
     */
    @Test
    public void TestCase3() {
        int[] nums = {1, 2, 3};
        int expectedResult = 3;

        evalueateSolution(nums, expectedResult);
    }

    private void evalueateSolution(int[] nums, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.rob(nums);

        assertEquals(expectedResult, actualResult);
    }

}
