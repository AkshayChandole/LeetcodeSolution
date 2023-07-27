package Stack.LargestRectangleInHistogram;


import java.util.ArrayDeque;
import java.util.Deque;

// ********************************************************************************
// Optimal Solution Using Stack -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int largestArea = Integer.MIN_VALUE;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        for (int i = 0; i < n; i++) {
            while ((stack.peek() != -1) && heights[i] <= heights[stack.peek()]) {
                int currentHeight = heights[stack.pop()];
                int currentWidth = i - stack.peek() - 1;
                largestArea = Math.max(largestArea, currentWidth * currentHeight);
            }
            stack.push(i);
        }

        while ((stack.peek() != -1)) {
            int currentHeight = heights[stack.pop()];
            int currentWidth = n - stack.peek() - 1;
            largestArea = Math.max(largestArea, currentWidth * currentHeight);
        }

        return largestArea;
    }
}

// ******************************************************************************
// Better Solution using Divide and Conquer Algorithm

/**
 * Time Complexity - O(n*log(n))
 * Space Complexity - O(n)
 */
class Solution2 {
    public int largestRectangleArea(int[] heights) {

        return calculateArea(heights, 0, heights.length - 1);
    }

    private int calculateArea(int[] heights, int start, int end) {
        if (start > end) return 0;
        int minimumIndex = start;

        for (int i = start; i <= end; i++) {
            if (heights[minimumIndex] > heights[i]) {
                minimumIndex = i;
            }
        }

        return Math.max(heights[minimumIndex] * (end - start + 1), Math.max(calculateArea(heights, start, minimumIndex - 1), calculateArea(heights, minimumIndex + 1, end)));
    }
}

// *************************************************************
// Brute Force Solution-

/**
 * Time Complexity - O(n^3)
 * Space Complexity - O(1)
 */
class Solution1 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int largestArea = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int minimumHeight = Integer.MAX_VALUE;

                for (int k = i; k <= j; k++) {
                    minimumHeight = Math.min(minimumHeight, heights[k]);
                }

                largestArea = Math.max(largestArea, minimumHeight * (j - i + 1));
            }

        }
        return largestArea;
    }
}
