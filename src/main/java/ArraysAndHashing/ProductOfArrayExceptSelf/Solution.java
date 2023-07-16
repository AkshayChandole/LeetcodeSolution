package ArraysAndHashing.ProductOfArrayExceptSelf;

/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixArray = new int[n];

        prefixArray[0] = 1;
        for (int i = 1; i < n; i++) {
            prefixArray[i] = prefixArray[i - 1] * nums[i - 1];
        }

        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            prefixArray[i] = suffixProduct * prefixArray[i];
            suffixProduct *= nums[i];
        }
        return prefixArray;
    }
}

/**
 * Time Complexity - O(n)
 * Space Complexity - O(n) + O(n)
 */
class Solution1 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixArray = new int[n];
        int[] suffixArray = new int[n];

        prefixArray[0] = 1;
        for (int i = 1; i < n; i++) {
            prefixArray[i] = prefixArray[i - 1] * nums[i - 1];
        }

        suffixArray[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffixArray[i] = suffixArray[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = prefixArray[i] * suffixArray[i];
        }

        return nums;
    }
}
