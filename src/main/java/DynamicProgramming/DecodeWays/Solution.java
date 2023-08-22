package DynamicProgramming.DecodeWays;

// **********************************************************************************
// Optimal Solution using Dynamic Programming with constant space -

/**
 * Time Complexity - O(N), where N is the length of the string.
 * Space Complexity - O(1).
 */
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();

        int twoBack = 1;      // for empty string
        int oneBack = s.charAt(0) == '0' ? 0 : 1;
        int current = oneBack;

        for (int i = 2; i <= n; i++) {
            current = 0;

            if (s.charAt(i - 1) != '0') {
                current += oneBack;
            }
            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                current += twoBack;
            }

            twoBack = oneBack;
            oneBack = current;
        }

        return current;
    }
}

// **********************************************************************************
// Better Solution using Dynamic Programming -

/**
 * Time Complexity - O(N), where N is the length of the string.
 * Space Complexity - O(N) for dynamic programming array.
 */
class Solution2 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();

        int[] dp = new int[n + 1];
        dp[0] = 1;      // for empty string
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}

// **********************************************************************************
// Brute Force solution using Recursion -

/**
 * Time Complexity - O(2^N), where N is the length of the string. In the worst case, we could have two branching choices for every single digit.
 * Space Complexity - O(N) due to the maximum depth of the recursion stack
 */
class Solution1 {
    public int numDecodings(String s) {
        return decode(s, 0);
    }

    private int decode(String s, int index) {
        // If we're at the end of the string, it's a valid decoding
        if (index == s.length()) {
            return 1;
        }

        // Leading zeros are not valid in any encoding
        if (s.charAt(index) == '0') {
            return 0;
        }

        // Only one decoding for single digits (except '0')
        int ans = decode(s, index + 1);

        // If next two digits form a number <= 26, consider them as well
        if (index < s.length() - 1 && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            ans += decode(s, index + 2);
        }

        return ans;
    }
}
