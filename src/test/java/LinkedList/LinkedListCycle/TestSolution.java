package LinkedList.LinkedListCycle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: head = [3,2,0,-4], pos = 1
    Output: true
     */
    @Test
    public void TestCase1() {
        Solution.ListNode head = new Solution.ListNode(3);
        Solution.ListNode node1 = new Solution.ListNode(2);
        Solution.ListNode node2 = new Solution.ListNode(0);
        Solution.ListNode node3 = new Solution.ListNode(-4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        boolean expectedResult = true;

        evaluateSolution(head, expectedResult);
    }

    /*
    Input: head = [1,2], pos = 0
    Output: true
     */
    @Test
    public void TestCase2() {
        Solution.ListNode head = new Solution.ListNode(1);
        Solution.ListNode node1 = new Solution.ListNode(2);

        head.next = node1;
        node1.next = head;

        boolean expectedResult = true;

        evaluateSolution(head, expectedResult);
    }

    /*
   Input: head = [1], pos = -1
   Output: false
    */
    @Test
    public void TestCase3() {
        Solution.ListNode head = new Solution.ListNode(1);

        head.next = null;

        boolean expectedResult = false;

        evaluateSolution(head, expectedResult);
    }

    private void evaluateSolution(Solution.ListNode head, boolean expectedResult) {
        Solution solution = new Solution();
        boolean actualResult = solution.hasCycle(head);

        assertEquals(expectedResult, actualResult);
    }
}
