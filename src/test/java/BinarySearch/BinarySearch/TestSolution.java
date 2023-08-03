package BinarySearch.BinarySearch;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSolution {
    /*
    Input: nums = [-1,0,3,5,9,12], target = 9
    Output: 4
     */
    @Test
    public void TestCase1() {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        int expectedResult = 4;
        evaluateSolution(nums, target, expectedResult);
    }

    /*
    Input: nums = [-1,0,3,5,9,12], target = 2
    Output: -1
     */
    @Test
    public void TestCase2() {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 2;
        int expectedResult = -1;
        evaluateSolution(nums, target, expectedResult);
    }

    private void evaluateSolution(int[] nums, int target, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.search(nums, target);
        assertEquals(expectedResult, actualResult);
    }
}
