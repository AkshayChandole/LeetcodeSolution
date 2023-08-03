package BinarySearch.SearchInRotatedSortedArray;


// **********************************************************************
// Optimal Solution using Binary Search -

/**
 * Time Complexity - O(log(n))
 * Space Complexity - O(1)
 */
public class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // if mid-pointer points to the target
            if (nums[mid] == target) {
                return mid;
            }

            // if left part is sorted
            if (nums[start] <= nums[mid]) {
                // if element exists in left part
                if (nums[start] <= target && target <= nums[mid]) {
                    // eliminate the right part
                    end = mid - 1;
                }
                // if element does not exist in left part
                else {
                    // eliminate the left part
                    start = mid + 1;
                }
            }

            // if right part is sorted
            else {
                // if element exists in right part
                if (nums[mid] <= target && target <= nums[end]) {
                    // eliminate the left part
                    start = mid + 1;
                }
                // if element does not exist in right part
                else {
                    // eliminate the right part
                    end = mid - 1;
                }

            }
        }

        return -1;
    }
}

// **********************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */
class Solution1 {
    public int search(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }
}

