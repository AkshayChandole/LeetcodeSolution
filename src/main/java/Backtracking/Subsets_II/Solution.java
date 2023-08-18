package Backtracking.Subsets_II;

import java.util.*;

// *******************************************************************
// Optimal Solution using backtracking -

/**
 * Time Complexity - O(N * 2^N) - This is because, in the worst case, we could have 2^N subsets and it takes O(N) time to generate a subset.
 * Space Complexity - O(N) - Space is used by the recursion stack.
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort the numbers
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}


// *************************************************************************
// Brute Force Solution using Bits Manipulation

/**
 * Time Complexity - O(N * 2^N) for generating all subsets.
 * Space Complexity - O(2^N) to store all unique subsets.
 */
class Solution1 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> current = new ArrayList<>();

        // Generate all subsets using bit manipulation
        for (int i = 0; i < (1 << nums.length); i++) {
            current.clear();

            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    current.add(nums[j]);
                }
            }
            // Add the sorted version to the set to avoid duplicates
            Collections.sort(current);
            result.add(new ArrayList<>(current));
        }
        return new ArrayList<>(result);
    }
}
