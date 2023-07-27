package LinkedList.ReverseLinkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    @Test
    public void TestCase1() {
        // head = [1,2,3,4,5]
        Solution.ListNode head = new Solution.ListNode(5);
        head = new Solution.ListNode(4, head);
        head = new Solution.ListNode(3, head);
        head = new Solution.ListNode(2, head);
        head = new Solution.ListNode(1, head);

        Solution solution = new Solution();
        Solution.ListNode headOfReverseList = solution.reverseList(head);

        // Output = [5,4,3,2,1]
        assertEquals(5, headOfReverseList.val);
        headOfReverseList = headOfReverseList.next;
        assertEquals(4, headOfReverseList.val);
        headOfReverseList = headOfReverseList.next;
        assertEquals(3, headOfReverseList.val);
        headOfReverseList = headOfReverseList.next;
        assertEquals(2, headOfReverseList.val);
        headOfReverseList = headOfReverseList.next;
        assertEquals(1, headOfReverseList.val);
    }

    @Test
    public void TestCase2() {
        // head = [1,2]
        Solution.ListNode head = new Solution.ListNode(2);
        head = new Solution.ListNode(1, head);

        Solution solution = new Solution();
        Solution.ListNode headOfReverseList = solution.reverseList(head);

        // Output = [2,1]
        assertEquals(2, headOfReverseList.val);
        headOfReverseList = headOfReverseList.next;
        assertEquals(1, headOfReverseList.val);
    }

    @Test
    public void TestCase3() {
        // head = []
        Solution.ListNode head = new Solution.ListNode();

        Solution solution = new Solution();
        Solution.ListNode headOfReverseList = solution.reverseList(head);

        // Output = []
        assertEquals(head.val, headOfReverseList.val);
    }
}
