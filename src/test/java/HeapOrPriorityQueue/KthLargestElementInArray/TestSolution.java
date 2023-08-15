package HeapOrPriorityQueue.KthLargestElementInArray;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    /*
    Input: nums = [3,2,1,5,6,4], k = 2
    Output: 5
     */
    @Test
    public void TestCase1(){
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;

        int expectedResult = 5;

        evaluateSolution(nums, k, expectedResult);
    }

    /*
    Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
    Output: 4
     */
    @Test
    public void TestCase2(){
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;

        int expectedResult = 5;

        evaluateSolution(nums, k, expectedResult);
    }

    private void evaluateSolution(int[] nums, int k, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.findKthLargest(nums, k);

        assertEquals(actualResult, expectedResult);
    }

}
