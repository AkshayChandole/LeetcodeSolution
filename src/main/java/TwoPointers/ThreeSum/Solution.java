package TwoPointers.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// ***************************************************************
// Optimal Solution -

/**
 * Time Complexity - O(n^2)
 * Space Complexity - O(t) where t is number of triplets
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int target = 0 - nums[i];
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    if (nums[left] + nums[right] == target) {
                        ArrayList<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[left]);
                        triplet.add(nums[right]);
                        answer.add(triplet);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return answer;
    }
}

// ***************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(n^3)
 * Space Complexity - O(t) where t is number of triplets
 * Note - This code does not have code check for duplicate triplets.
 */
class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int i, j, k;

        for (i = 0; i < nums.length - 2; i++) {
            for (j = i + 1; j < nums.length - 1; j++) {
                for (k = j + 1; k < nums.length; k++) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                    }
                    if ((temp.size() != 0) && !(ans.contains(temp))) ans.add(temp);
                }
            }
        }

        return ans;
    }
}
