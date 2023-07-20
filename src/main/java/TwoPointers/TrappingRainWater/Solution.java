package TwoPointers.TrappingRainWater;

// **********************************************************************
// Optimal Solution using Two-pointers Solution -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */
public class Solution {
    static int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int waterTrapped = 0;
        int maxLeft = 0, maxRight = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    waterTrapped += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    waterTrapped += maxRight - height[right];
                }
                right--;
            }
        }
        return waterTrapped;
    }
}

// **********************************************************************
// Better Solution using Dynamic Programming -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
class Solution2 {
    static int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int waterTrapped = 0;
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        for (int i = 1; i < n - 1; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        for (int i = 1; i < n - 1; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            waterTrapped += min > height[i] ? min - height[i] : 0;
        }

        return waterTrapped;
    }
}

// **********************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(n^2)
 * Space Complexity - O(1)
 */
class Solution1 {
    static int trap(int[] height) {
        int n = height.length;
        int waterTrapped = 0;

        for (int i = 0; i < n; i++) {
            int j = i;
            int leftMax = 0, rightMax = 0;
            while (j >= 0) {
                leftMax = Math.max(leftMax, height[j]);
                j--;
            }
            j = i;
            while (j < n) {
                rightMax = Math.max(rightMax, height[j]);
                j++;
            }
            waterTrapped += Math.min(leftMax, rightMax) - height[i];
        }

        return waterTrapped;
    }
}
