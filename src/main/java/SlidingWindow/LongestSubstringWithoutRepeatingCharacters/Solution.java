package SlidingWindow.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// ****************************************************************
// Optimal Solution using Sliding Window and HashMap -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int leftPointer =0;
        int rightPointer = 0;
        int n =s.length();
        int answer = 0;

        while(rightPointer<n){
            if(map.containsKey(s.charAt(rightPointer)))
                leftPointer = Math.max(map.get(s.charAt(rightPointer))+1, leftPointer);
            map.put(s.charAt(rightPointer),rightPointer);
            answer = Math.max(answer, rightPointer-leftPointer+1);
            rightPointer++;
        }

        return answer;
    }
}

// ****************************************************************
// Better Solution using Sliding Window and Hashset -

/**
 * Time Complexity - O(2*n) ...(sometimes left and right both have to travel complete array)
 * Space Complexity - O(n)
 */
class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        int answer = 0;
        Set<Character> characterSet = new HashSet<>();
        int leftPointer = 0;

        for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            if (characterSet.contains(s.charAt(rightPointer))) {
                while (leftPointer < rightPointer && characterSet.contains(s.charAt(rightPointer))) {
                    characterSet.remove(s.charAt(leftPointer));
                    leftPointer++;
                }
            }
            characterSet.add(s.charAt(rightPointer));
            answer = Math.max(answer, rightPointer - leftPointer + 1);
        }

        return answer;
    }
}

// ****************************************************************
// Brute Force Solution using HashSet -

/**
 * Time Complexity - O(n^2)
 * Space Complexity - O(n)
 */
class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            Set<Character> characterSet = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                Character ch = s.charAt(j);
                if (characterSet.contains(ch)) {
                    answer = Math.max(answer, j - i);
                    break;
                }
                characterSet.add(ch);
            }
        }

        return answer;
    }
}
