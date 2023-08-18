package Backtracking.CombinationSum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// **************************************************************************************************
// Optimal Solution using backtracking -

/**
 * Time Complexity - O(N * 2^T) where N is the number of candidates, and T is the average size of the combinations.
 * Space Complexity - O(T) where T is the average size of the combinations (due to recursion).
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        // If remain is negative, no solution is possible, backtrack
        if (remain < 0) {
            return;
        }

        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            tempList.add(candidates[i]);

            // As each number can be used only once, the next recursive call will have i+1 as start index
            backtrack(result, tempList, candidates, remain - candidates[i], i + 1);

            // Undo the last choice for backtracking
            tempList.remove(tempList.size() - 1);
        }
    }
}
