package TwoPointers.TwoSumII_InputArrayIsSorted;

import java.util.HashMap;
import java.util.Map;

// *******************************************
// Optimal Solution -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start + 1, end + 1};
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else end--;
        }
        return new int[0];
    }
}

// *******************************************
// Better Solution using Binary Search -

/**
 * Time Complexity - O(n.log(n))
 * Space Complexity - O(1)
 */
class Solution3 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1;
            int high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }
}

// *******************************************
// Better Solution using HashMap -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
class Solution2 {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]), i + 1};
            }

            map.putIfAbsent(numbers[i], i + 1);
        }

        return new int[0];
    }
}

// *******************************************
// Brute Force Solution -

/**
 * Time Complexity - O(n^2)
 * Space Complexity - O(1)
 */
class Solution1 {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target && (i != j)) {
                    answer[0] = i + 1;
                    answer[1] = j + 1;
                    return answer;
                }
            }
        }
        return answer;
    }
}
