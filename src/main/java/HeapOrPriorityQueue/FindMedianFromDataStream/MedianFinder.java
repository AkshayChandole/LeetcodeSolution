package HeapOrPriorityQueue.FindMedianFromDataStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

// ***********************************************************************
// Optimal Solution -

/**
 * Time Complexity -
 * add - O(log(n)) because we might need to insert a number into a heap.
 * findMedian - O(1) because the medians are at the tops of the heaps.
 * Space Complexity - O(n) to store the numbers.
 */
class MedianFinder {
    PriorityQueue<Integer> maxHeap; // for numbers below median
    PriorityQueue<Integer> minHeap; // for numbers above median

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num);

        // balance the largest element of the max heap into the min heap
        minHeap.offer(maxHeap.poll());

        // Ensure both heaps are balanced (have nearly equal size)
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}


// ***********************************************************************
// Brute Force Solution -

/**
 * Time Complexity -
 *       add - O(1)
 *       findMedian - O(n * log(n)) due to sorting.
 * Space Complexity - O(n) due to arraylist to store numbers.
 */
class MedianFinder1 {
    List<Integer> numbers;

    public MedianFinder1() {
        numbers = new ArrayList<>();
    }

    public void addNum(int num) {
        numbers.add(num);
    }

    public double findMedian() {
        Collections.sort(numbers);
        int n = numbers.size();

        if (n % 2 == 0) {
            return ((numbers.get(n / 2 - 1) + numbers.get(n / 2)) / 2.0);
        } else {
            return numbers.get(n / 2);
        }
    }
}

