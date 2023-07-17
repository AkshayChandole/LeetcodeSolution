package ArraysAndHashing.MajorityElement;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSolution {
    @Test
    public void TestCase1() {
        int[] nums = new int[]{3, 2, 3};
        int expectedResult = 3;
        evaluateSolution(nums, expectedResult);
    }

    @Test
    public void TestCase2() {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        int expectedResult = 2;
        evaluateSolution(nums, expectedResult);
    }

    @Test
    public void TestCase3() {
        int[] nums = new int[]{3,3,4};
        int expectedResult = 3;
        evaluateSolution(nums, expectedResult);
    }

    private void evaluateSolution(int[] nums, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.majorityElement(nums);
        assertEquals(expectedResult, actualResult);
    }
}
