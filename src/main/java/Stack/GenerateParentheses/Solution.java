package Stack.GenerateParentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// *********************************************************************
// Optimal Solution -

/**
 * Time Complexity - O((4^n)/(√n)), in simple terms, the time complexity will be the nth Catalan number.
 * Space Complexity - O((4^n)/(√n)), including recursion stack space
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        int noOfOpenBrackets = 0;
        int noOfClosedBrackets = 0;
        backtrackingFunction(answer, "", noOfOpenBrackets, noOfClosedBrackets, n);
        return answer;
    }

    private void backtrackingFunction(List<String> answer, String currentString, int noOfOpenBrackets, int noOfClosedBrackets, int n) {
        if (currentString.length() == 2 * n) {
            answer.add(currentString);
            return;
        }

        if (noOfOpenBrackets < n)
            backtrackingFunction(answer, currentString + "(", noOfOpenBrackets + 1, noOfClosedBrackets, n);

        if (noOfClosedBrackets < noOfOpenBrackets)
            backtrackingFunction(answer, currentString + ")", noOfOpenBrackets, noOfClosedBrackets + 1, n);
    }
}

// *********************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O((2^(2*n))*n)
 * Space Complexity - O((2^(2*n))*n)
 */
class Solution1 {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        String currentString = "";
        generateString(currentString, n, answer);
        return answer;
    }

    void generateString(String currentString, int n, List<String> answer) {
        if (currentString.length() == (n * 2)) {
            if (isValidParentheses(currentString)) {
                answer.add(currentString);
            }
            return;
        }
        generateString(currentString + '(', n, answer);
        generateString(currentString + ')', n, answer);
    }

    boolean isValidParentheses(String string) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            char currentCharacter = string.charAt(i);
            if (currentCharacter == '(' || currentCharacter == '[' || currentCharacter == '{') {
                stack.push(currentCharacter);
                continue;
            }

            if (stack.empty()) {
                return false;
            }

            char topCharacter = stack.peek();
            stack.pop();

            switch (currentCharacter) {
                case ')':
                    if (topCharacter == '{' || topCharacter == '[') return false;
                    break;
                case '}':
                    if (topCharacter == '(' || topCharacter == '[') return false;
                    break;
                case ']':
                    if (topCharacter == '(' || topCharacter == '{') return false;
                    break;
                default:
                    return false;
            }
        }

        return stack.empty();
    }

}
