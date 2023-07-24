package SlidingWindow.MinimumWindowSubstring;

// *******************************************************************************
// Optimal Solution -

/**
 * Time Complexity - O(n) + O(m)    ...(where n and m are lengths of strings s and t)
 * Space Complexity - O(1)
 */
public class Solution {
    public String minWindow(String s, String t) {
        String result = "";

        if (t.length() > s.length()) {
            return "";
        }

        int n = s.length(), m = t.length();
        int freq1[] = new int[128];
        int freq2[] = new int[128];

        for (char c : t.toCharArray()) {
            freq1[c]++;
        }

        int l = 0, len = n + 1;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            char temp = s.charAt(i);
            freq2[temp]++;

            if (freq1[temp] != 0 && freq2[temp] <= freq1[temp]) {
                cnt++;
            }

            if (cnt == m) {
                while (freq2[s.charAt(l)] > freq1[s.charAt(l)] || freq1[s.charAt(l)] == 0) {
                    if (freq2[s.charAt(l)] > freq1[s.charAt(l)]) {
                        freq2[s.charAt(l)]--;
                    }
                    l++;
                }

                if (len > i - l + 1) {
                    len = i - l + 1;
                    result = s.substring(l, l + len);
                }
            }
        }
        return (result.length() == 0 ? "" : result);
    }
}

// *******************************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(n^3)
 * Space Complexity - O(1)
 */
class Solution1 {
    public String minWindow(String s, String t) {
        String result = "";

        if (t.length() > s.length()) {
            return "";
        }

        int freq1[] = new int[128];
        int n = s.length();

        for (int i = 0; i < t.length(); i++) {
            freq1[(int) t.charAt(i)]++;
        }

        int len = n + 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int freq2[] = new int[128];

                for (int k = i; k <= j; k++) {
                    freq2[s.charAt(k)]++;
                }

                for (int k = 0; k < 128; k++) {
                    if (freq2[k] < freq1[k]) {
                        break;
                    }
                    if (k == 127) {
                        if (len > (j - i)) {
                            len = j - i;
                            result = s.substring(i, j + 1);
                        }
                    }
                }
            }
        }
        return (result.length() == 0 ? "" : result);
    }
}
