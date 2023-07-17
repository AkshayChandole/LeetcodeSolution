package ArraysAndHashing.ReversePairs;


// **************************************************************
// Optimal Solution -

/**
 * Time Complexity - O(n*log(n))
 * Space Complexity - O(n)
 */
public class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] res = new int[1];
        mergeSort(nums, 0, n - 1, res);
        return res[0];
    }

    public void mergeSort(int[] nums, int start, int end, int[] res) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid, res);
        mergeSort(nums, mid + 1, end, res);

        int count = 0;
        int left = start, right = mid + 1;

        while (left <= mid) {
            if (right <= end && (nums[left] > 2 * (long) nums[right])) {
                ++count;
                ++right;
            } else {
                res[0] += count;
                ++left;
            }
        }
        merge(nums, start, mid, end);
    }

    public void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= end) {
            temp[k++] = nums[j++];
        }

        for (int m = start; m <= end; m++) {
            nums[m] = temp[m - start];
        }
    }
}


// **************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(n^2)
 * Space Complexity - O(1)
 */
class Solution1 {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {     // O(n)
            for (int j = i + 1; j < n; j++) {     // O(n)
                if (nums[i] > 2 * (long) nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
