package SlidingWindow.LongestRepeatingCharacterReplacement;

import java.util.HashMap;
import java.util.Map;

// ********************************************************************
// Optimal Solution -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */
public class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int ans = 0;
        int max = 0;
        int leftPointer = 0;

        for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            int index = s.charAt(rightPointer) - 'A';
            arr[index]++;
            max = Math.max(max, arr[index]);
            if (rightPointer - leftPointer - max >= k) {
                arr[s.charAt(leftPointer) - 'A']--;
                leftPointer++;
            }
            ans = Math.max(ans, rightPointer - leftPointer + 1);
        }
        return ans;

    }
}


// ********************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
class Solution1 {
    public int characterReplacement(String s, int k) {
        int answer = 0;
        int leftPointer = 0;
        int maxRepeat = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            char curr = s.charAt(rightPointer);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            maxRepeat = Math.max(maxRepeat, map.get(curr));
            if (rightPointer - leftPointer - maxRepeat >= k) {
                char remove = s.charAt(leftPointer);
                map.put(remove, map.get(remove) - 1);
                leftPointer++;
            }
            answer = Math.max(answer, rightPointer - leftPointer + 1);

        }
        return answer;
    }
}
