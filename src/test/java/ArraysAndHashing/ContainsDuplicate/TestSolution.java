package ArraysAndHashing.ContainsDuplicate;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSolution {
    @Test
    public void TestCase1() {
        int[] nums = new int[]{1, 2, 3, 1};
        boolean expectedAnswer = true;
        evaluateSolution(nums, expectedAnswer);
    }

    @Test
    public void TestCase2() {
        int[] nums = new int[]{1, 2, 3, 4};
        boolean expectedAnswer = false;
        evaluateSolution(nums, expectedAnswer);
    }

    @Test
    public void TestCase3() {
        int[] nums = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        boolean expectedAnswer = true;
        evaluateSolution(nums, expectedAnswer);
    }

    private void evaluateSolution(int[] nums, boolean expectedAnswer) {
        Solution solution = new Solution();
        boolean actualAnswer = solution.containsDuplicate(nums);
        assertEquals(expectedAnswer, actualAnswer);
    }
}
