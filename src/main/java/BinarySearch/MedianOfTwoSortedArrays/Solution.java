package BinarySearch.MedianOfTwoSortedArrays;

// *********************************************************************************
// Optimal Solution Using Binary Search -

/**
 * Time Complexity - O(log(min(m,n)))
 * Space Complexity - O(1)
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int total = m + n;
        int half = (total + 1) / 2;

        int left = 0;
        int right = m;

        var result = 0.0;

        while (left <= right) {
            int i = left + (right - left) / 2;
            int j = half - i;

            // get the four points around possible median
            int left1 = (i > 0) ? nums1[i - 1] : Integer.MIN_VALUE;
            int right1 = (i < m) ? nums1[i] : Integer.MAX_VALUE;
            int left2 = (j > 0) ? nums2[j - 1] : Integer.MIN_VALUE;
            int right2 = (j < n) ? nums2[j] : Integer.MAX_VALUE;

            // partition is correct
            if (left1 <= right2 && left2 <= right1) {
                // even
                if (total % 2 == 0) {
                    result = (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                    // odd
                } else {
                    result = Math.max(left1, left2);
                }
                break;
            }

            // partition is wrong (update left/right pointers)
            else if (left1 > right2) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }

        return result;

    }
}

// *********************************************************************************
// Better Solution -

/**
 * Time Complexity - O(m + n)
 * Space Complexity - O(1)
 */
class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0;
        int j = 0;
        int count;
        int median1 = -1, median2 = -1;

        for (count = 0; count <= (m + n) / 2; count++) {
            median2 = median1;
            if (i != m && j != n) {
                median1 = (nums1[i] > nums2[j]) ? nums2[j++] : nums1[i++];
            } else if (i < m) {
                median1 = nums1[i++];
            } else {
                median1 = nums2[j++];
            }
        }

        if ((n + m) % 2 == 1) {
            return median1;
        } else {
            return (median1 + median2) / 2.0;
        }

    }
}

// *********************************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(m + n)
 * Space Complexity - O(m + n)
 */
class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] mergedArray = new int[m + n];

        int pointer1 = 0, pointer2 = 0, pointer3 = 0;

        while (pointer1 < m && pointer2 < n) {
            if (nums1[pointer1] <= nums2[pointer2]) {
                mergedArray[pointer3++] = nums1[pointer1++];
            } else {
                mergedArray[pointer3++] = nums2[pointer2++];
            }
        }

        while (pointer1 < m) {
            mergedArray[pointer3++] = nums1[pointer1++];
        }

        while (pointer2 < n) {
            mergedArray[pointer3++] = nums2[pointer2++];
        }

        int len = m + n;

        if (len % 2 == 1) {
            return mergedArray[((len + 1) / 2) - 1];
        } else {
            return ((double) mergedArray[(len / 2) - 1] + (double) mergedArray[(len / 2)]) / 2.0;
        }

    }
}
