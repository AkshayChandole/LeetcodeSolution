package DynamicProgramming.LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;

// **************************************************************************
// Optimal Solution using Dynamic Programming and binary search -

/**
 * Given N as the length of nums -
 *
 * Time Complexity - O(N * log(N))
 * Space Complexity - O(N)
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> subSequence = new ArrayList<>();
        subSequence.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            
            if (num > subSequence.get(subSequence.size() - 1)) {
                subSequence.add(num);
            } 
            else {
                int j = binarySearch(subSequence, num);
                subSequence.set(j, num);
            }
        }

        return subSequence.size();
    }

    private int binarySearch(ArrayList<Integer> subSequence, int num) {
        int left = 0;
        int right = subSequence.size() - 1;
        int mid = (left + right) / 2;

        while (left < right) {
            mid = (left + right) / 2;
            if (subSequence.get(mid) == num) {
                return mid;
            }

            if (subSequence.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

// **************************************************************************
// Better Solution using Dynamic Programming memoization -

/**
 * Time Complexity - O(N * N), where N is the length of the input array.
 * Space Complexity - O(N * N) + O(N) due to dp array and the recursion stack.
 */
class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return lengthOfLIS(nums, -1, 0, dp);
    }

    private int lengthOfLIS(int[] nums, int previousIndex, int currentIndex, int[][] dp) {
        if (currentIndex == nums.length) {
            return 0;
        }

        if(dp[currentIndex][previousIndex + 1] != -1) {
            return dp[currentIndex][previousIndex + 1];
        }

        int taken = 0;
        if (previousIndex == -1 || nums[currentIndex] > nums[previousIndex]) {
                taken = 1 + lengthOfLIS(nums, currentIndex, currentIndex + 1, dp);
        }

        int notTaken = lengthOfLIS(nums, previousIndex, currentIndex + 1, dp);

        dp[currentIndex][previousIndex + 1] = Math.max(taken, notTaken);

        return dp[currentIndex][previousIndex + 1];
    }
}

// **************************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(2^N), where N is the length of the input array.
 * Space Complexity - O(N) due to the recursion stack.
 */
class Solution1 {
    public int lengthOfLIS(int[] nums) {
        return lengthOfLIS(nums, Integer.MIN_VALUE, 0);
    }

    private int lengthOfLIS(int[] nums, int prev, int currentIndex) {
        if (currentIndex == nums.length) {
            return 0;
        }

        int taken = 0;
        if (nums[currentIndex] > prev) {
            taken = 1 + lengthOfLIS(nums, nums[currentIndex], currentIndex + 1);
        }

        int notTaken = lengthOfLIS(nums, prev, currentIndex + 1);
        return Math.max(taken, notTaken);
    }
}
