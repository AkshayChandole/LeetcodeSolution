package ArraysAndHashing.LongestConsecutiveSequence;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Optimal Approach

/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        int answer = 1;

        for (int num : nums)
            set.add(num);

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int count = 1;
                while (set.contains(num + 1)) {
                    num++;
                    count++;
                }
                answer = Math.max(count, answer);
            }
        }

        return answer;
    }
}

// *******************************************************************
// Brute Force Approach

/**
 * Time Complexity - O(n*log(n)) ...(due to sorting)
 * Space Complexity - O(1)
 */
class Solution1 {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        int answer = 1;
        int previousNumber = nums[0];
        int currentLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == previousNumber + 1) {
                currentLength++;
            } else if (nums[i] != previousNumber) {
                currentLength = 1;
            }
            previousNumber = nums[i];
            answer = Math.max(answer, currentLength);
        }

        return answer;
    }
}