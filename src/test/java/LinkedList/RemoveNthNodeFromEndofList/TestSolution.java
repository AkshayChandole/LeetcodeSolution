package LinkedList.RemoveNthNodeFromEndofList;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSolution {
    /*
    Input: head = [1,2,3,4,5], n = 2
    Output: [1,2,3,5]
     */
    @Test
    public void TestCase1() {
        Solution.ListNode head = new Solution.ListNode(5);
        head = new Solution.ListNode(4, head);
        head = new Solution.ListNode(3, head);
        head = new Solution.ListNode(2, head);
        head = new Solution.ListNode(1, head);
        int n = 2;

        Solution solution = new Solution();
        Solution.ListNode output = solution.removeNthFromEnd(head, n);

        assertEquals(1, output.val);
        output = output.next;
        assertEquals(2, output.val);
        output = output.next;
        assertEquals(3, output.val);
        output = output.next;
        assertEquals(5, output.val);
    }

    /*
    Input: head = [1], n = 1
    Output: []
     */
    @Test
    public void TestCase2() {
        Solution.ListNode head = new Solution.ListNode(1);
        int n = 1;

        Solution solution = new Solution();
        Solution.ListNode output = solution.removeNthFromEnd(head, n);

        assertEquals(null, output);
    }

    /*
    Input: head = [1,2], n = 1
    Output: [1]
     */
    @Test
    public void TestCase3() {
        Solution.ListNode head = new Solution.ListNode(2);
        head = new Solution.ListNode(1, head);
        int n = 1;

        Solution solution = new Solution();
        Solution.ListNode output = solution.removeNthFromEnd(head, n);

        assertEquals(1, output.val);
    }
}

