package HeapOrPriorityQueue.KthLargestElementInStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// **********************************************************************
// Optimal Solution using Priority Queue -

/**
 * Time Complexity -
 *          Initialization: O(n * log k) where n is the number of initial elements. This is because we're inserting each element into a heap of size at most k.
 *          Add: O(log k) because the heap's size is at most k.
 * Space Complexity -
 *          O(k) for storing the top k elements.
 */
class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        // add the number to minHeap
        minHeap.offer(val);

        // if heap size is greater than k, remove the smallest element
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        // the top of the min-heap is the kth largest element.
        return minHeap.peek();
    }
}

// **********************************************************************
// Brute Force Solution -

/**
 * Time Complexity -
 *      Initialization: O(n * log n) where n is the number of initial elements, due to sorting.
 *      Add: O(n * log n) because you sort the list every time you add an element.
 * Space Complexity -
 *      O(N) for storing the elements.
 */
class KthLargest1 {
    private List<Integer> list;
    private int k;

    public KthLargest1(int k, int[] nums) {
        this.list = new ArrayList<>();
        for (int num : nums) {
            this.list.add(num);
        }
        this.k = k;
    }

    public int add(int val) {
        list.add(val);
        Collections.sort(list);
        return list.get(list.size() - k);
    }
}
