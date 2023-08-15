package HeapOrPriorityQueue.KClosestPointsToOrigin;

import java.util.Arrays;
import java.util.PriorityQueue;

// ***********************************************************************
// Optimal Solution using max-heap -

/**
 * Time Complexity - O(n * log k) because we're maintaining a max-heap of size k.
 * Space Complexity - O(N) to store the distances.
 */
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Use a max-heap based on distance to the origin
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> (p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]));

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        while (k > 0) {
            result[--k] = maxHeap.poll();
        }

        return result;
    }
}


// ***********************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(n * logn), where n is the number of points. The dominating factor is the sorting step.
 * Space Complexity - O(N) to store the distances.
 */
class Solution1 {
    public int[][] kClosest(int[][] points, int k) {
        // Sort the given points based on their distance from the origin
        Arrays.sort(points, (p1, p2) -> (p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]));

        return Arrays.copyOfRange(points, 0, k);
    }
}