package ArraysAndHashing.MajorityElement;

import java.util.HashMap;

// ****************************************************************
// Optimal Solution by Moore’s Voting Algorithm -

/**
 * Time Complexity - O(n) + O(n)
 * Space Complexity - O(1)
 */

public class Solution {
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 0;
        int element = 0;

        //Applying Moore’s Voting Algorithm:
        for (int num : nums) {      // O(n)
            if (count == 0) {
                count = 1;
                element = num;
            } else if (element == num) count++;
            else count--;
        }

        //Validating if element is the majority element or not
        int elementCounter = 0;
        for (int num : nums) {       // O(n)
            if (num == element) elementCounter++;
        }

        if (elementCounter > (n / 2)) return element;
        return -1;
    }
}


// ****************************************************************
// Better Solution -

/**
 * Time Complexity - O(n*log(n)) + O(n)
 * Space Complexity - O(n)
 */

class Solution2 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            int count = hashMap.getOrDefault(num, 0);
            hashMap.put(num, ++count); // O(n*log(n))
            if (count > (n / 2)) //O(n)
                return num;
        }
        return -1;
    }
}

// ****************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(n^2)
 * Space Complexity - O(1)
 */

class Solution1 {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        for (int num : nums) {
            int count = 0;
            for (int tempNum : nums) {
                if (tempNum == num) {
                    count++;
                }
            }
            if (count > (n / 2)) return num;
        }

        return -1;
    }
}
