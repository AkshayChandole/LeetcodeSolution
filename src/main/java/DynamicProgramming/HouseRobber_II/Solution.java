package DynamicProgramming.HouseRobber_II;

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
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robLinear(nums, 0, nums.length - 2),
                robLinear(nums, 1, nums.length - 1));
    }

    private int robLinear(int[] nums, int start, int end) {
        int prevMax = 0;
        int currMax = 0;

        for (int i = start; i <= end; i++) {
            int temp = currMax;
            currMax = Math.max(prevMax + nums[i], currMax);
            prevMax = temp;
        }

        return currMax;
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
        // If only one house, return its value
        if (nums.length == 1) {
            return nums[0];
        }

        // Compute max between robbing starting from 0th house and ending before last
        // OR
        // Starting from 1st house and going till the end
        return Math.max(robHelper(nums, 0, nums.length - 2, new Integer[nums.length]),
                robHelper(nums, 1, nums.length - 1, new Integer[nums.length]));
    }

    private int robHelper(int[] nums, int start, int end, Integer[] memo) {
        // Base condition
        if (start > end) {
            return 0;
        }

        // If this subproblem is already solved, return the answer
        if (memo[start] != null) {
            return memo[start];
        }

        // Either rob the current house or skip it
        int robCurrent = nums[start] + robHelper(nums, start + 2, end, memo);
        int skipCurrent = robHelper(nums, start + 1, end, memo);

        // Store the result in memo array and return
        memo[start] = Math.max(robCurrent, skipCurrent);
        return memo[start];
    }
}