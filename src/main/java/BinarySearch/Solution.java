package BinarySearch;

/**
 * Binary Search
 * Time Complexity - O(log(n))
 * Space Complexity - O(1)
 */
public class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else end = mid - 1;
        }

        return -1;
    }
}
