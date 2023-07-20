package TwoPointers.ContainerWithMostWater;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    @Test
    public void TestCase1() {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int expectedResult = 49;
        evaluateSolution(height, expectedResult);
    }

    @Test
    public void TestCase2() {
        int[] height = new int[]{1, 1};
        int expectedResult = 1;
        evaluateSolution(height, expectedResult);
    }

    @Test
    public void TestCase3() {
        int[] height = new int[]{2, 3, 4, 5, 18, 17, 6};
        int expectedResult = 17;
        evaluateSolution(height, expectedResult);
    }

    private void evaluateSolution(int[] height, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.maxArea(height);
        assertEquals(expectedResult, actualResult);
    }


}
