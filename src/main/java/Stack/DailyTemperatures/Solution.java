package Stack.DailyTemperatures;

import java.util.Stack;

// **********************************************************************************
// Optimal Solution -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        return answer;
    }
}

// *************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(n^2)
 * Space Complexity - O(1)
 */
class Solution1 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int daysRemainingForWarmerTemperature = 0;
            for (int j = i; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    daysRemainingForWarmerTemperature = j - i;
                    break;
                }
            }
            answer[i] = daysRemainingForWarmerTemperature;
        }

        return answer;
    }
}
