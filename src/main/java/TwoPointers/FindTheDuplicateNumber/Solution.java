package TwoPointers.FindTheDuplicateNumber;

import java.util.Arrays;

// ***************************************************************
// Optimal Solution using two pointers -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

// ***************************************************************
// Better Solution using frequency array -

/**
 * Note - This solution uses extra space.
 * <p>
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
class Solution3 {
    public int findDuplicate(int[] nums) {
        int[] frequency = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            if (frequency[nums[i]] == 0) frequency[nums[i]]++;
            else return nums[i];
        }

        return -1;
    }
}

// ***************************************************************
// Better Solution using Array.Sort() -


/**
 * Note - This method involves modification in the array.
 * <p>
 * Time Complexity - O(n*log(n)+n)
 * Space Complexity - O(1)
 */
class Solution2 {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return nums[i];
        }

        return -1;
    }
}

// ***************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(n^2)
 * Space Complexity - O(1)
 */
class Solution1 {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] - nums[j] == 0) return nums[i];
            }
        }
        return -1;
    }
}

