package BinarySearch.FindMinimumInRotatedSortedArray;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: nums = [3,4,5,1,2]
    Output: 1
     */
    @Test
    public void TestCase1() {
        int[] nums = new int[]{3, 4, 5, 1, 2};
        int expectedResult = 1;
        evaluateSolution(nums, expectedResult);
    }

    /*
    Input: nums = [4,5,6,7,0,1,2]
    Output: 0
     */
    @Test
    public void TestCase2() {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int expectedResult = 0;
        evaluateSolution(nums, expectedResult);
    }

    /*
    Input: nums = [11,13,15,17]
    Output: 11
     */
    @Test
    public void TestCase3() {
        int[] nums = new int[]{11, 13, 15, 17};
        int expectedResult = 11;
        evaluateSolution(nums, expectedResult);
    }

    private void evaluateSolution(int[] nums, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.findMin(nums);
        assertEquals(expectedResult, actualResult);
    }
}
