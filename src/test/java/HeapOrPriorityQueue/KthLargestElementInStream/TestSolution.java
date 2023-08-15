package HeapOrPriorityQueue.KthLargestElementInStream;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    /*
     Input:
        ["KthLargest", "add", "add", "add", "add", "add"]
        [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
    Output:
        [null, 4, 5, 5, 8, 8]
     */
    @Test
    public void TestCase1() {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        assertEquals(4, kthLargest.add(3));
        assertEquals(5, kthLargest.add(5));
        assertEquals(5, kthLargest.add(10));
        assertEquals(8, kthLargest.add(9));
        assertEquals(8, kthLargest.add(4));
    }
}
