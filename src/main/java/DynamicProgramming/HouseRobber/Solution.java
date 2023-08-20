package DynamicProgramming.HouseRobber;

// ****************************************************************
// Optimal solution using Dynamic Programming with Constant Space -

/**
 * Time Complexity - O(N)
 * Space Complexity - O(1)
 */
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int previousMax = 0;
        int currentMax = 0;

        for (int num : nums) {
            int temp = currentMax;
            currentMax = Math.max(previousMax + num, currentMax);
            previousMax = temp;
        }

        return currentMax;
    }
}

// ****************************************************************
// Better solution using Dynamic Programming -

/**
 * Time Complexity - O(N), where N is the number of houses.
 * Space Complexity - O(N) for the dynamic programming array.
 */
class Solution2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }
}


// ****************************************************************
// Brute force solution using recursion -

/**
 * Time Complexity - O(2^N), where N is the number of houses. This is because for each house you have 2 choices (either to rob or not to rob).
 * Space Complexity - O(N) due to the recursion stack.
 */
class Solution1 {
    public int rob(int[] nums) {
        return robHelper(nums, 0);
    }

    private int robHelper(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }

        // Either rob the current house or skip it
        return Math.max(nums[i] + robHelper(nums, i + 2), robHelper(nums, i + 1));
    }
}
