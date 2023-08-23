package DynamicProgramming.CoinChange;

import java.util.Arrays;

// ***********************************************************************
// Brute Force solution using Dynamic Programming -

/**
 * Time Complexity - O(S * n), where S is the amount and n is the length of the coin denomination array.
 * Space Complexity - O(S^n), where S is the amount.
 */
class Solution {

    public int coinChange(int[] coins, int amount) {
        // dp[i] will represent minimum number of coins required for 'i' amount
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }

                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }
}

// ***********************************************************************
// Better solution using recursion with memorization -

/**
 * Time Complexity - O(S * n), where S is the amount and n is the length of the coin denomination array.
 * Space Complexity - O(S), where S is the amount.
 */
class Solution2 {
    private Integer[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new Integer[amount + 1];
        return recursionHelper(coins, amount);
    }

    private int recursionHelper(int[] coins, int remain) {
        if (remain < 0) {
            return -1;
        }

        if (remain == 0) {
            return 0;
        }

        if (memo[remain] != null) {
            return memo[remain];
        }

        int minCount = Integer.MAX_VALUE;

        for (int coin : coins) {
            int count = recursionHelper(coins, remain - coin);
            if (count == -1) {
                continue;
            }

            minCount = Math.min(minCount, count + 1);
        }

        memo[remain] = minCount == Integer.MAX_VALUE ? -1 : minCount;

        return memo[remain];
    }

}

// ***********************************************************************
// Brute Force solution using recursion -

/**
 * Time Complexity - O(S^n), where S is the amount and n is the length of the coin denomination array. This is an upper bound, with the worst case being the amount composed of 1-cent coins.
 * Space Complexity - O(N), where N is the amount to be formed. This is due to the maximum depth of the recursion stack.
 */
class Solution1 {

    public int coinChange(int[] coins, int amount) {
        return recursionHelper(coins, amount);
    }

    private int recursionHelper(int[] coins, int remain) {
        if (remain < 0) {
            return -1;
        }

        if (remain == 0) {
            return 0;
        }

        int minCount = Integer.MAX_VALUE;

        for (int coin : coins) {
            int count = recursionHelper(coins, remain - coin);
            if (count == -1) {
                continue;
            }

            minCount = Math.min(minCount, count + 1);
        }

        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }
}