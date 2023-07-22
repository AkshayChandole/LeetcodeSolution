package SlidingWindow.BestTimeToBuyAndSellStock;

// **********************************************************************
// Optimal Solution -

/**
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int maxStockProfit = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            min = Math.min(min, price);
            maxStockProfit = Math.max(maxStockProfit, price - min);
        }
        return maxStockProfit;
    }
}

// **********************************************************************
// Brute Force Solution -

/**
 * Time complexity - O(n^2)
 * Space complexity - O(1)
 */
class Solution1 {
    public int maxProfit1(int[] prices) {
        int maxStockProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int diff = prices[j] - prices[i];
                if (diff > 0) {
                    maxStockProfit = Math.max(diff, maxStockProfit);
                }
            }
        }
        return maxStockProfit;
    }
}