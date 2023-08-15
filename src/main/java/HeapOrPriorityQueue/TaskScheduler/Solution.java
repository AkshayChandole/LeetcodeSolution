package HeapOrPriorityQueue.TaskScheduler;

import java.util.*;

// *******************************************************************
// Optimal Solution solution -

/**
 * Time Complexity - O(n * log(k)) where n is the number of tasks and k is the distinct number of tasks (since there are at most 26 tasks, O(log k) is practically O(1)).
 * Space Complexity - O(1), because we're storing a maximum of 26 tasks.
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        for (char t : tasks) {
            frequencies[t - 'A']++;
        }

        // Max heap based on frequencies
        PriorityQueue<Integer> heap = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int f : frequencies) {
            if (f > 0) {
                heap.offer(f);
            }
        }

        int cycles = 0;

        while (!heap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            // For each cycle
            for (int i = 0; i < n + 1; i++) {
                if (!heap.isEmpty()) {
                    temp.add(heap.poll());
                }
            }
            // Decrement the count of each task in the current cycle
            for (int item : temp) {
                if (--item > 0) {
                    heap.offer(item);
                }
            }
            // If heap is empty, no more tasks remain; otherwise, add the length of the cycle
            cycles += heap.isEmpty() ? temp.size() : n + 1;
        }

        return cycles;
    }
}


// *******************************************************************
// Brute Force solution -

/**
 * Time Complexity - O(n * log(n)) due to sorting.
 * Space Complexity - O(1), since we're dealing with a maximum of 26 tasks.
 */
class Solution1 {
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];

        for (char ch : tasks) {
            frequencies[ch - 'A']++;
        }

        // Sort the tasks by frequencies
        Arrays.sort(frequencies);

        // Max Frequency
        int f_max = frequencies[25];
        int idle_time = (f_max - 1) * n;

        for (int i = frequencies.length - 2; i >= 0 && idle_time > 0; i--) {
            idle_time -= Math.min(f_max - 1, frequencies[i]);
        }

        idle_time = Math.max(0, idle_time);

        return tasks.length + idle_time;
    }
}
