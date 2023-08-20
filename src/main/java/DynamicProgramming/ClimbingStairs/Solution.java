package DynamicProgramming.ClimbingStairs;

// *******************************************************************************
// Optimal Solution -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */
class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int prev2 = 1;
        int prev1 = 1;

        for (int i = 2; i <= n; i++) {
            int temp = prev2 + prev1;
            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;
    }
}

// *******************************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
class Solution1 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}