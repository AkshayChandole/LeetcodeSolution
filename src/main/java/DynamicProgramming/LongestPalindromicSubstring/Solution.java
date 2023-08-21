package DynamicProgramming.LongestPalindromicSubstring;

// ******************************************************************************************
// Optimal Solution using Expanding Around Center -

/**
 * Time Complexity - O(N^2). Each expansion can potentially go for the length of the string.
 * Space Complexity - O(1). No additional space is used based on input size.
 */
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // For odd length palindromic substring
            int len1 = expandFromMiddle(s, i, i);

            // For odd length palindromic substring
            int len2 = expandFromMiddle(s, i, i + 1);

            int len = Math.max(len1, len2);

            if(len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }

    private int expandFromMiddle(String s, int left, int right) {
        while(left>=0 && right <s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1; // Subtract 1 to offset extra addition in the loop
    }

}


// ******************************************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(N^3). This is because generating all substrings takes O(N^2) time, and verifying if a string is a palindrome takes O(N).
 * Space Complexity - O(1). This approach doesn't use any additional space proportional to the input size.
 */
class Solution1 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }

        String longestPalindromeString = "";

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String subString = s.substring(i, j);

                if (isPalindrome(subString) && subString.length() > longestPalindromeString.length()) {
                    longestPalindromeString = subString;
                }
            }
        }

        return longestPalindromeString;
    }

    private boolean isPalindrome(String subString) {
        int start = 0, end = subString.length() - 1;

        while (start < end) {
            if (subString.charAt(start++) != subString.charAt(end--)) {
                return false;
            }
        }

        return true;
    }
}
