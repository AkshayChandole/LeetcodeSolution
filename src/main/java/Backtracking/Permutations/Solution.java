package Backtracking.Permutations;

import java.util.ArrayList;
import java.util.List;

// *************************************************************
// Optimal Solution using Backtracking -

/**
 * Time Complexity - O(N!) since there are N! possible permutations.
 * Space Complexity - O(N) for the recursion stack.
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                // skip if element already exists in tempList
                if (tempList.contains(nums[i])) {
                    continue;
                }

                tempList.add(nums[i]);
                backtrack(result, tempList, nums);

                // undo last choice for backtracking
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
