package DynamicProgramming.MinCostClimbingStairs;

// *******************************************************************************
// Optimal Solution using Space-optimized Dynamic Programming -

/**
 * Time Complexity - O(N), where N is the length of the cost array.
 * Space Complexity - O(1)
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int minCostForPreviousFirstStair = 0;
        int minCostForPreviousSecondStair = 0;

        for (int i = 0; i < n; i++) {
            int costForCurrentStair = cost[i] + Math.min(minCostForPreviousFirstStair, minCostForPreviousSecondStair);
            minCostForPreviousSecondStair = minCostForPreviousFirstStair;
            minCostForPreviousFirstStair = costForCurrentStair;
        }

        return Math.min(minCostForPreviousFirstStair, minCostForPreviousSecondStair);
    }
}

// *******************************************************************************
// Better Solution using Dynamic Programming -

/**
 * Time Complexity - O(N), where N is the length of the cost array.
 * Space Complexity - O(N) due to the dp array.
 */
class Solution2 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }
}

// *******************************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(2^N), where N is the length of the cost array. This is because for each step you have 2 choices (either step one or step two).
 * Space Complexity - O(N) due to the recursion stack.
 */
class Solution1 {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(minCost(0, cost), minCost(1, cost));
    }

    private int minCost(int i, int[] cost) {
        if (i >= cost.length) {
            return 0;
        }

        return cost[i] + Math.min(minCost(i + 1, cost), minCost(i + 2, cost));
    }
}
