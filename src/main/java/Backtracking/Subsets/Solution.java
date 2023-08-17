package Backtracking.Subsets;

import java.util.ArrayList;
import java.util.List;

// ****************************************************************
// Optimal solution using Bits Manipulation -

/**
 * Time Complexity -  O(N * 2^N) - For every number from 0 to 2^N - 1, and for each number, we take O(N) time to generate its corresponding subset.
 * Space Complexity - O(N * 2^N).
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int p = 1 << n;

        List<List<Integer>> output = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            List<Integer> subset = new ArrayList<>();

            for (int j = 0; j < n; j++) {

                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }

            output.add(subset);
        }
        return output;
    }
}

// ****************************************************************
// Another solution using Backtracking -

/**
 * Time Complexity -  O(N * 2^N) - This is because we have 2^N possible subsets and, on average, it takes O(N) time to make a copy of them.
 * Space Complexity - O(N * 2^N).
 */
class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(output, new ArrayList<>(), nums, 0);
        return output;
    }

    private void backtrack(List<List<Integer>> output, List<Integer> current, int[] nums, int start) {
        output.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(output, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }
}


// ****************************************************************
// Brute Force solution using Cascading -

/**
 * Time Complexity - O(N * 2^N) - Every time we add a new element, we double the subsets count.
 * Space Complexity - O(N * 2^N) - In total, we will have 2^N subsets, and the average length of subsets will be N/2.
 */
class Solution1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());

        for(int num : nums){
            List<List<Integer>> subsetList = new ArrayList<>();

            for(List<Integer> currentSubset : output){
                List<Integer> newSubset = new ArrayList<>(currentSubset);
                newSubset.add(num);
                subsetList.add(newSubset);
            }

            output.addAll(subsetList);
        }

        return output;
    }
}