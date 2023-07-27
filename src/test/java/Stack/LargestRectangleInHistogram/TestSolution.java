package Stack.LargestRectangleInHistogram;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    @Test
    public void TestCase1() {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        int expectedResult = 10;
        evaluateSolution(heights, expectedResult);
    }

    @Test
    public void TestCase2() {
        int[] heights = new int[]{2, 4};
        int expectedResult = 4;
        evaluateSolution(heights, expectedResult);
    }

    private void evaluateSolution(int[] heights, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.largestRectangleArea(heights);
        assertEquals(expectedResult, actualResult);
    }

}
