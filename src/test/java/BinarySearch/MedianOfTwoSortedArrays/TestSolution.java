package BinarySearch.MedianOfTwoSortedArrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: nums1 = [1,3], nums2 = [2]
    Output: 2.00000
     */
    @Test
    public void TestCase1() {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        double expectedResult = 2.00000;
        evaluateSolution(nums1, nums2, expectedResult);
    }

    /*
    Input: nums1 = [1,2], nums2 = [3,4]
    Output: 2.50000
     */
    @Test
    public void TestCase2() {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        double expectedResult = 2.50000;
        evaluateSolution(nums1, nums2, expectedResult);
    }

    private void evaluateSolution(int[] nums1, int[] nums2, double expectedResult) {
        Solution solution = new Solution();
        double actualResult = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expectedResult, actualResult,0.00001);
    }
}
