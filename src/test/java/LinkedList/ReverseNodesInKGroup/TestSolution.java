package LinkedList.ReverseNodesInKGroup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: head = [1,2,3,4,5], k = 2
    Output: [2,1,4,3,5]
     */
    @Test
    public void TestCase1() {
        Solution.ListNode head = new Solution.ListNode(5);
        head = new Solution.ListNode(4, head);
        head = new Solution.ListNode(3, head);
        head = new Solution.ListNode(2, head);
        head = new Solution.ListNode(1, head);

        int k = 2;

        Solution solution = new Solution();
        Solution.ListNode output = solution.reverseKGroup(head, k);

        assertEquals(2, output.val);
        output = output.next;
        assertEquals(1, output.val);
        output = output.next;
        assertEquals(4, output.val);
        output = output.next;
        assertEquals(3, output.val);
        output = output.next;
        assertEquals(5, output.val);
    }

    /*
    Input: head = [1,2,3,4,5], k = 3
    Output: [3,2,1,4,5]
     */
    @Test
    public void TestCase2() {
        Solution.ListNode head = new Solution.ListNode(5);
        head = new Solution.ListNode(4, head);
        head = new Solution.ListNode(3, head);
        head = new Solution.ListNode(2, head);
        head = new Solution.ListNode(1, head);

        int k = 3;

        Solution solution = new Solution();
        Solution.ListNode output = solution.reverseKGroup(head, k);

        assertEquals(3, output.val);
        output = output.next;
        assertEquals(2, output.val);
        output = output.next;
        assertEquals(1, output.val);
        output = output.next;
        assertEquals(4, output.val);
        output = output.next;
        assertEquals(5, output.val);
    }


}
