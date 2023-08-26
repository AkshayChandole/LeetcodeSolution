package DynamicProgramming.PartitionEqualSubsetSum;

// *************************************************************************************
// Optimal Solution using Dynamic Programming -

/**
 * Let n be the number of array elements and m be the subsetSum
 *
 * Time Complexity -  O(m * n)
 * Space Complexity - O(subsetSum) for dp array
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int subsetSum = totalSum / 2;
        boolean[] dp = new boolean[subsetSum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = subsetSum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[subsetSum];
    }
}

// *****************************************************************************
// Better Solution using recursion with memoization -

/**
 * Let n be the number of array elements and m be the subSetSum
 * <p>
 * Time Complexity -   O(m * n)
 * Space Complexity -  O(m * n) + O(n) for memo array and recursion stack space
 */
class Solution2 {
    private Boolean[][] memo;

    public boolean canPartition(int[] nums) {
        int totalSum = 0;

        // find the sum of all array elements
        for (int num : nums) {
            totalSum += num;
        }

        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if (totalSum % 2 != 0) {
            return false;
        }

        int subsetSum = totalSum / 2;
        memo = new Boolean[nums.length + 1][subsetSum + 1];

        return dfs(nums, 0, subsetSum);
    }

    private boolean dfs(int[] nums, int index, int subsetSum) {
        // Base case
        if (subsetSum == 0) {
            return true;
        }
        if (index == nums.length || subsetSum < 0) {
            return false;
        }

        if (memo[index][subsetSum] != null) {
            return memo[index][subsetSum];
        }

        boolean result = dfs(nums, index + 1, subsetSum - nums[index]) || dfs(nums, index + 1, subsetSum);
        memo[index][subsetSum] = result;

        return result;
    }

}

// *****************************************************************************
// Brute Force Solution using recursion -

/**
 * Time Complexity -  O(2^n), where n is number of array elements.
 * The recursive solution takes the form of a binary tree where there are 2 possibilities for every array element
 * and the maximum depth of the tree could be n.
 * The time complexity is exponential, hence this approach is exhaustive and results in Time Limit Exceeded (TLE).
 * <p>
 * Space Complexity -  O(N)
 * This space will be used to store the recursion stack.
 */
class Solution1 {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;

        // find the sum of all array elements
        for (int num : nums) {
            totalSum += num;
        }

        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if (totalSum % 2 != 0) {
            return false;
        }

        int subsetSum = totalSum / 2;

        return dfs(nums, 0, subsetSum);
    }

    private boolean dfs(int[] nums, int index, int subsetSum) {
        // Base case
        if (subsetSum == 0) {
            return true;
        }
        if (index == nums.length || subsetSum < 0) {
            return false;
        }

        return dfs(nums, index + 1, subsetSum - nums[index]) || dfs(nums, index + 1, subsetSum);
    }
}
