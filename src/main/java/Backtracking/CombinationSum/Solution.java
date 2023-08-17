package Backtracking.CombinationSum;

import java.util.ArrayList;
import java.util.List;

// *****************************************************************************
// Optimal Solution using backtracking -

/**
 * Time Complexity - O(N * 2^T) where N is the number of candidates, and T is the maximum number of repeated use of a candidate. This is a worst-case scenario when we explore each possibility.
 * Space Complexity - O(T) where T is the maximum number of repeated use of a candidate (due to recursion).
 */

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        // If remain is negative, no solution is possible, backtrack
        if (remain < 0) return;

        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);

                // Pass i as the next start because we can reuse the same elements
                backtrack(result, tempList, candidates, remain - candidates[i], i);

                // Undo the last choice
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}