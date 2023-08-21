package DynamicProgramming.PalindromicSubstrings;

// ******************************************************************************************
// Optimal Solution using Expanding Around Center -

/**
 * Time Complexity - O(N^2). Each expansion can potentially go for the length of the string.
 * Space Complexity - O(1). No additional space is used based on input size.
 */
class Solution {
    int count = 0;

    public int countSubstrings(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // For odd length palindromic substring
            expandFromMiddle(s, i, i);

            // For odd length palindromic substring
            expandFromMiddle(s, i, i + 1);
        }

        return count;
    }

    private void expandFromMiddle(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
    }

}

// **************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(N^3). This is because generating all substrings takes O(N^2) time, and verifying if a string is a palindrome takes O(N).
 * Space Complexity - O(1). This approach doesn't use any additional space that scales with the input size.
 */
class Solution1 {
    public int countSubstrings(String s) {
        int n = s.length();
        if (n < 1) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String substring = s.substring(i, j);
                if (isPalindromic(substring)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isPalindromic(String s) {
        int start = 0, end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }
}
