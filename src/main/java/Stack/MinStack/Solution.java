package Stack.MinStack;

import java.util.Stack;

/**
 * For all operations -
 *
 * Time Complexity - O(1)
 * Space Complexity - O(n)
 */
public class Solution {
    static class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);

            // The min stack may be empty, so we need to check it
            val = Math.min(val, minStack.isEmpty() ? val : minStack.peek());
            minStack.push(val);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
