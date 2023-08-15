package HeapOrPriorityQueue.LastStoneWeight;

import java.util.*;

// *************************************************************************
// Optimal Solution Using Max-Heap -

/**
 * Time Complexity - O(n * log(n)) for inserting elements in a max-heap.
 * Space Complexity - O(n) to store the stones.
 */
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();

            if (x != y) {
                maxHeap.add(y - x);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}


// *************************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(n * (n * log(n))) where N is the number of stones. The list is sorted in every iteration.
 * Space Complexity - O(n) to store the stones.
 */
class Solution1 {
    public int lastStoneWeight(int[] stones) {
        List<Integer> stoneList = new ArrayList<>();

        for (int stone : stones) {
            stoneList.add(stone);
        }

        while (stoneList.size() > 1) {
            Collections.sort(stoneList);
            int y = stoneList.remove(stoneList.size() - 1);
            int x = stoneList.remove(stoneList.size() - 1);

            if (x != y) {
                stoneList.add(y - x);
            }
        }

        return stoneList.isEmpty() ? 0 : stoneList.get(0);
    }
}
