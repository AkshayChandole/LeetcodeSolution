package Stack.ValidParentheses;

import java.util.Stack;

// *********************************************************
// Optimal Solution -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (final char c : s.toCharArray())
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;

        return stack.isEmpty();
    }
}
