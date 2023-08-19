package Backtracking.LetterCombinationsOfPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// *************************************************************************
// Optimal Solution using backtracking -

/**
 * Time Complexity - O(4^N * N), where N is the number of digits in the input string. This is because, in the worst case, each digit has 4 possible letters (like digit 7 or 9 on a phone keypad) and we have to iterate for each combination.
 * <p>
 * Space Complexity - O(N), primarily for the recursion stack.
 */

public class Solution {
    private Map<Character, String> dialPad = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }

        return result;
    }

    private void backtrack(String combination, String nextDigits) {
        if (nextDigits.length() == 0) {
            result.add(combination);
        } else {
            char digit = nextDigits.charAt(0);
            String letters = dialPad.get(digit);

            for (int i = 0; i < letters.length(); i++) {
                String letter = dialPad.get(digit).substring(i, i + 1);
                backtrack(combination + letter, nextDigits.substring(1));
            }
        }
    }
}
