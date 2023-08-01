package TwoPointers.FindTheDuplicateNumber;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSolution {
    /*
    Input: nums = [1,3,4,2,2]
    Output: 2
     */
    @Test
    public void TestCase1() {
        int[] nums = new int[]{1, 3, 4, 2, 2};
        int expectedResult = 2;
        evaluateSolution(nums, expectedResult);
    }

    /*
    Input: nums = [3,1,3,4,2]
    Output: 3
     */
    @Test
    public void TestCase2() {
        int[] nums = new int[]{3, 1, 3, 4, 2};
        int expectedResult = 3;
        evaluateSolution(nums, expectedResult);
    }

    private void evaluateSolution(int[] nums, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.findDuplicate(nums);
        assertEquals(expectedResult, actualResult);
    }
}
