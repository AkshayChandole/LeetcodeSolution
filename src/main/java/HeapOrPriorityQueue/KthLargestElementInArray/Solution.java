package HeapOrPriorityQueue.KthLargestElementInArray;

import java.util.Arrays;
import java.util.PriorityQueue;

// **********************************************************************
// Optimal Solution -

/**
 * Time Complexity - O(n * log(k)). This is because we're inserting each element into a min-heap of size k.
 * Space Complexity - O(k) for the min-heap.
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}


// **********************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(n * log(n)) where n is the number of elements. This is because the sorting step dominates the complexity.
 * Space Complexity - O(1) or O(n), depending on the sorting algorithm (usually O(1) with in-place sorts like heapsort, quicksort or insertion sort).
 */
class Solution1 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
