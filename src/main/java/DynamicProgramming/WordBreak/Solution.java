package DynamicProgramming.WordBreak;

import java.util.*;

// ****************************************************************************************
// Optimal Solution using top-down dynamic programming -

/**
 * Given n as the length of s, m as the length of wordDict, and k as the average length of the words in wordDict -
 * <p>
 * Time Complexity - O(n * m * k)
 * Space Complexity - O(n)
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                // Handle out of bounds case
                if (i < word.length() - 1) {
                    continue;
                }

                if (i == word.length() - 1 || dp[i - word.length()]) {
                    if (s.substring(i - word.length() + 1, i + 1).equals(word)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[s.length() - 1];
    }
}

// ****************************************************************************************
// Brute Force Solution -

/*
Complexity Analysis :
    Given n as the length of s, m as the length of wordDict, and k as the average length of the words in wordDict -
        Time complexity: O(n^3 + m⋅k)
            There are O(n) nodes. Because of seen, we never visit a node more than once. At each node, we iterate over the nodes in front of the current node, of which there are O(n). For each node end, we create a substring, which also costs O(n).
            Therefore, handling a node costs O(n^2), so the BFS could cost up to O(n^3). Finally, we also spent O(m⋅k) to create the set words.
        Space complexity: O(n + m⋅k)
            We use O(n) space for queue and seen. We use O(m⋅k) space for the set words.
*/

class Solution1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] seen = new boolean[s.length() + 1];
        queue.add(0);

        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (start == s.length()) {
                return true;
            }

            for (int end = start + 1; end <= s.length(); end++) {
                if (seen[end]) {
                    continue;
                }

                if (words.contains(s.substring(start, end))) {
                    queue.add(end);
                    seen[end] = true;
                }
            }
        }

        return false;
    }
}
