package ArraysAndHashing.TopKFrequentElements;

import java.util.*;

// *********************************************************************
// Optimal Solution

/**
 * Time Complexity: O(nlog(k))
 * Space Complexity: O(n)
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            pq.add(it);
            if (pq.size() > k) pq.poll();
        }
        int i = k;
        while (!pq.isEmpty()) {
            arr[--i] = pq.poll().getKey();
        }
        return arr;
    }
}

// ***********************************************************************
// Brute Force Approach -

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution1 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int num : nums)
            count.merge(num, 1, Integer::sum);

        for (int key : count.keySet()) {
            int freq = count.get(key);
            if (bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }

        int index = 0;
        int[] res = new int[k];
        for (int i = nums.length; i >= 0; i--)
            if (bucket[i] != null) for (int val : bucket[i]) {
                res[index++] = val;
                if (index == k) return res;
            }
        return res;
    }
}
