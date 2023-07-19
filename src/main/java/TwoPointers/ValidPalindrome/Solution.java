package TwoPointers.ValidPalindrome;

// Optimal Solution using two pointers method -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;

        int start = 0;
        int last = s.length() - 1;

        while (start < last)       // O(n)
        {
            char charStart = s.charAt(start);
            char charLast = s.charAt(last);

            if (!Character.isLetterOrDigit(charStart)) {
                start++;
            } else if (!Character.isLetterOrDigit(charLast)) {
                last--;
            } else {
                if (Character.toLowerCase(charStart) != Character.toLowerCase(charLast)) {
                    return false;
                }
                start++;
                last--;
            }

        }
        return true;
    }
}