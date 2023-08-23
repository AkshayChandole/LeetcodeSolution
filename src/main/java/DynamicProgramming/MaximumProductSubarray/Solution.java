package DynamicProgramming.MaximumProductSubarray;

// *****************************************************************
// Optimal Solution using Dynamic Programming -

/**
 * Time complexity - O(N) where N is the size of nums.
 * Space complexity - O(1)
 */

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i < nums.length; i++) {
            int currentNumber = nums[i];
            int temp_max = Math.max(currentNumber, Math.max(max_so_far * currentNumber, min_so_far * currentNumber));
            min_so_far = Math.min(currentNumber, Math.min(max_so_far * currentNumber, min_so_far * currentNumber));

            max_so_far = temp_max;

            result = Math.max(result, max_so_far);
        }

        return result;
    }
}

// *****************************************************************
// Brute Force Solution -

/**
 * Time complexity - O(N^2) where N is the size of nums. Since we are checking every possible contiguous sub-array following every element in nums we have quadratic runtime.
 * Space complexity - O(1)
 */

class Solution1 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int result = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int product = 1;

            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                result = Math.max(result, product);
            }
        }

        return result;
    }
}
