package BinarySearch.SearchInRotatedSortedArray;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSolution {
    /*
    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4
     */
    @Test
    public void TestCase1() {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int expectedResult = 4;
        evaluateSolution(nums, target, expectedResult);
    }

    /*
    Input: nums = [4,5,6,7,0,1,2], target = 3
    Output: -1
     */
    @Test
    public void TestCase2() {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        int expectedResult = -1;
        evaluateSolution(nums, target, expectedResult);
    }

    private void evaluateSolution(int[] nums, int target, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.search(nums, target);
        assertEquals(expectedResult, actualResult);
    }
}
