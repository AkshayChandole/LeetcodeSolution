package TwoPointers.ContainerWithMostWater;

// **********************************************************
// Optimal Solution -

/**
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
public class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int answer = 0;

        while (start < end) {
            int dx = end - start;
            int dy = Math.min(height[start], height[end]);
            answer = Math.max(answer, dx * dy);
            if (height[start] <= height[end]) start++;
            else end--;
        }

        return answer;
    }
}

// **********************************************************
// Brute Force Solution -

/**
 * Time complexity - O(n^2)
 * Space complexity - O(1)
 */
class Solution1 {
    public int maxArea(int[] height) {
        int n = height.length;
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int dx = j - i;
                int dy = Math.min(height[i], height[j]);
                answer = Math.max(answer, dx * dy);
            }
        }

        return answer;
    }
}
