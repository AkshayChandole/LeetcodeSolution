package Backtracking.PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;


// *************************************************************************
// Optimal Solution using backtracking -

/**
 * Time Complexity - O( (2^n) *k*(n/2) )
 * Reason: O(2^n) to generate every substring and O(n/2)  to check if the substring generated is a palindrome. O(k) is for inserting the palindromes in another data structure, where k  is the average length of the palindrome list.
 * <p>
 * Space Complexity: O(k * x) where k is the average length of the list of palindromes and if we have x such list of palindromes in our final answer. The depth of the recursion tree is n, so the auxiliary space required is equal to the O(n).
 */
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> tempList, String s, int index) {
        if (index == s.length()) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = index; i < s.length(); ++i) {
            if (isPalindrome(s, index, i)) {
                tempList.add(s.substring(index, i + 1));
                backtrack(result, tempList, s, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
