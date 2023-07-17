package ArraysAndHashing.TopKFrequentElements;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestSolution {

    @Test
    public void TestCase1() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] expectedAnswer = new int[]{1, 2};
        evaluateSolution(nums, k, expectedAnswer);
    }

    @Test
    public void TestCase2() {
        int[] nums = new int[]{1};
        int k = 1;
        int[] expectedAnswer = new int[]{1};
        evaluateSolution(nums, k, expectedAnswer);
    }

    private void evaluateSolution(int[] nums, int k, int[] expectedAnswer) {
        Solution solution = new Solution();
        int[] actualAnswer = solution.topKFrequent(nums, k);
        assertArrayEquals(expectedAnswer, actualAnswer);
    }
}
