package LinkedList.ReorderList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: head = [1,2,3,4]
    Output: [1,4,2,3]
     */
    @Test
    public void TestCase1() {
        Solution.ListNode head = new Solution.ListNode(4);
        head = new Solution.ListNode(3, head);
        head = new Solution.ListNode(2, head);
        head = new Solution.ListNode(1, head);

        Solution solution = new Solution();
        solution.reorderList(head);

        assertEquals(1, head.val);
        head = head.next;
        assertEquals(4, head.val);
        head = head.next;
        assertEquals(2, head.val);
        head = head.next;
        assertEquals(3, head.val);

    }

    /*
    Input: head = [1,2,3,4,5]
    Output: [1,5,2,4,3]
     */
    @Test
    public void TestCase2() {
        Solution.ListNode head = new Solution.ListNode(5);
        head = new Solution.ListNode(4, head);
        head = new Solution.ListNode(3, head);
        head = new Solution.ListNode(2, head);
        head = new Solution.ListNode(1, head);

        Solution solution = new Solution();
        solution.reorderList(head);

        assertEquals(1, head.val);
        head = head.next;
        assertEquals(5, head.val);
        head = head.next;
        assertEquals(2, head.val);
        head = head.next;
        assertEquals(4, head.val);
        head = head.next;
        assertEquals(3, head.val);

    }
}
