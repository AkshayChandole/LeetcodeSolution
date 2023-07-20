package TwoPointers.TrappingRainWater;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSolution {
    @Test
    public void TestCase1() {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int expectedResult = 6;
        evaluateSolution(height, expectedResult);
    }

    @Test
    public void TestCase2() {
        int[] height = new int[]{4, 2, 0, 3, 2, 5};
        int expectedResult = 9;
        evaluateSolution(height, expectedResult);
    }

    private void evaluateSolution(int[] height, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.trap(height);
        assertEquals(expectedResult, actualResult);
    }
}

