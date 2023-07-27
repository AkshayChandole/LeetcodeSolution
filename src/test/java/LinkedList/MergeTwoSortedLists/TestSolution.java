package LinkedList.MergeTwoSortedLists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    @Test
    public void TestCase1() {
        // listNode1 = [1,2,4]
        Solution.ListNode listNode1 = new Solution.ListNode(4);
        listNode1 = new Solution.ListNode(2, listNode1);
        listNode1 = new Solution.ListNode(1, listNode1);

        // listNode2 = [1,3,4]
        Solution.ListNode listNode2 = new Solution.ListNode(4);
        listNode2 = new Solution.ListNode(3, listNode2);
        listNode2 = new Solution.ListNode(1, listNode2);

        Solution solution = new Solution();
        Solution.ListNode mergedListNode = solution.mergeTwoLists(listNode1, listNode2);

        // Output: [1,1,2,3,4,4]
        assertEquals(1, mergedListNode.val);
        mergedListNode = mergedListNode.next;
        assertEquals(1, mergedListNode.val);
        mergedListNode = mergedListNode.next;
        assertEquals(2, mergedListNode.val);
        mergedListNode = mergedListNode.next;
        assertEquals(3, mergedListNode.val);
        mergedListNode = mergedListNode.next;
        assertEquals(4, mergedListNode.val);
        mergedListNode = mergedListNode.next;
        assertEquals(4, mergedListNode.val);
    }

    @Test
    public void TestCase2() {
        // listNode1 = []
        Solution.ListNode listNode1 = new Solution.ListNode();

        // listNode2 = []
        Solution.ListNode listNode2 = new Solution.ListNode();

        Solution solution = new Solution();
        Solution.ListNode mergedListNode = solution.mergeTwoLists(listNode1, listNode2);

        // Output: []
        assertEquals(listNode1.val, mergedListNode.val);
        assertEquals(listNode2.val, mergedListNode.val);
    }

    @Test
    public void TestCase3() {
        // listNode1 = []
        Solution.ListNode listNode1 = new Solution.ListNode();

        // listNode2 = [0]
        Solution.ListNode listNode2 = new Solution.ListNode();

        Solution solution = new Solution();
        Solution.ListNode mergedListNode = solution.mergeTwoLists(listNode1, listNode2);

        // Output: []
        assertEquals(0, mergedListNode.val);
    }
}
