package SlidingWindow.BestTimeToBuyAndSellStock;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    @Test
    public void TestCase1() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int expectedResult = 5;
        evaluateSolution(prices, expectedResult);
    }

    @Test
    public void TestCase2() {
        int[] prices = new int[]{7, 6, 4, 3, 1};
        int expectedResult = 0;
        evaluateSolution(prices, expectedResult);
    }

    private void evaluateSolution(int[] prices, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.maxProfit(prices);
        assertEquals(expectedResult, actualResult);
    }
}
