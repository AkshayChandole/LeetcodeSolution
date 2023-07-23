package SlidingWindow.PermutationinString;

// **********************************************************************
// Solution using Constant-sized moving window -

/**
 * Time Complexity - O(|s1|+|s2|)
 * Space complexity - O(128)=O(1)
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[128];
        int required = s1.length();

        for (final char c : s1.toCharArray())
            ++count[c];

        for (int rightPointer = 0; rightPointer < s2.length(); ++rightPointer) {
            if (--count[s2.charAt(rightPointer)] >= 0) --required;
            if (rightPointer >= s1.length()) // The window is oversized
                if (++count[s2.charAt(rightPointer - s1.length())] > 0) ++required;
            if (required == 0) return true;
        }

        return false;
    }
}

// **********************************************************************
// Solution using classic sliding window -

/**
 * Time Complexity - O(|s1|+|s2|)
 * Space complexity - O(128)=O(1)
 */
class Solution1 {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[128];
        int required = s1.length();

        for (final char c : s1.toCharArray())
            ++count[c];

        for (int leftPointer = 0, rightPointer = 0; rightPointer < s2.length(); ++rightPointer) {
            if (--count[s2.charAt(rightPointer)] >= 0) --required;
            while (required == 0) {
                if (rightPointer - leftPointer + 1 == s1.length()) return true;
                if (++count[s2.charAt(leftPointer++)] > 0) ++required;
            }
        }

        return false;
    }
}
