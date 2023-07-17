package ArraysAndHashing.ValidAnagram;


// *******************************************************************
// Optimal Solution -

import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }

        return true;
    }
}

// *******************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
class Solution1 {
    public boolean isAnagram1(String s, String t) {
        Map<Character, Integer> map = new HashMap();
        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            Character ch = Character.toLowerCase(s.charAt(i));
            int count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            Character ch = Character.toLowerCase(t.charAt(i));
            if (!map.containsKey(ch) || map.get(ch) == 0) return false;
            map.put(ch, map.get(ch) - 1);
        }
        return true;
    }
}
