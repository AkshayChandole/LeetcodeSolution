package BinarySearch.FindMinimumInRotatedSortedArray;

// *************************************************************************
// Optimal Solution using Binary Search -

/**
 * Time Complexity - O(log(n))
 * Space Complexity - O(1)
 */
public class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int minimum = Integer.MAX_VALUE;

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // if search space is already sorted i.e. (nums[start]<=nums[mid] && nums[mid] <= nums[end]) is true
            // then nums[start] will always be the minimum in that search space:
            if (nums[start] <= nums[end]) {
                minimum = Math.min(minimum, nums[start]);
                break;
            }

            //if left part is sorted:
            if (nums[start] <= nums[mid]) {
                // keep the minimum:
                minimum = Math.min(minimum, nums[start]);
                // eliminate left half:
                start = mid + 1;
            }

            //if right part is sorted:
            else {
                // keep the minimum:
                minimum = Math.min(minimum, nums[mid]);
                // eliminate right half:
                end = mid - 1;
            }
        }

        return minimum;
    }
}

// *************************************************************************
// Better Solution using Binary Search -

/**
 * Time Complexity - O(log(n))
 * Space Complexity - O(1)
 */
class Solution2 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int minimum = Integer.MAX_VALUE;

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            //if left part is sorted:
            if (nums[start] <= nums[mid]) {
                // keep the minimum:
                minimum = Math.min(minimum, nums[start]);
                // eliminate left half:
                start = mid + 1;
            }

            //if right part is sorted:
            else {
                // keep the minimum:
                minimum = Math.min(minimum, nums[mid]);
                // eliminate right half:
                end = mid - 1;
            }
        }

        return minimum;
    }
}

// *************************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */
class Solution1 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int minimum = Integer.MAX_VALUE;

        for (int num : nums) {
            minimum = Math.min(minimum, num);
        }

        return minimum;
    }
}
