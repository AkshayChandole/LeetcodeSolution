package SlidingWindow.SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.Deque;

// ******************************************************
// Solution using Dynamic Programming -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            if (i % k == 0)
                left[i] = nums[i];
            else
                left[i] = Math.max(left[i - 1], nums[i]);
            int j = n - i - 1;
            if ((j + 1) % k == 0)
                right[j] = nums[j];
            else
                right[j] = Math.max(right[j + 1], nums[j]);
        }

        int[] output = new int[n - k + 1];

        for (int i = 0; i < n - k + 1; i++)
            output[i] = Math.max(left[i + k - 1], right[i]);

        return output;
    }
}

// ******************************************************
// Better Solution Using Deque -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(n–k+1)
 */
class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < nums.length; ++i) {
            while (!dq.isEmpty() && dq.peekLast() < nums[i])
                dq.pollLast();
            dq.offerLast(nums[i]);
            if (i >= k && nums[i - k] == dq.peekFirst())
                dq.pollFirst();
            if (i >= k - 1)
                ans[i - k + 1] = dq.peekFirst();
        }

        return ans;
    }
}

// ******************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(n^2)
 * Space Complexity - O(n–k+1)
 */
class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        int[] output = new int[n - k + 1];

        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++)
                max = Math.max(max, nums[j]);
            output[i] = max;
        }

        return output;
    }
}
