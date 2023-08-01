package LinkedList.MergeKSortedLists;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSolution {
    /*
    Input: lists = [[1,4,5],[1,3,4],[2,6]]
    Output: [1,1,2,3,4,4,5,6]
     */
    @Test
    public void TestCase1() {
        Solution.ListNode list1 = new Solution.ListNode(5);
        list1 = new Solution.ListNode(4, list1);
        list1 = new Solution.ListNode(1, list1);

        Solution.ListNode list2 = new Solution.ListNode(4);
        list2 = new Solution.ListNode(3, list2);
        list2 = new Solution.ListNode(1, list2);

        Solution.ListNode list3 = new Solution.ListNode(6);
        list3 = new Solution.ListNode(2, list3);

        Solution.ListNode[] lists = new Solution.ListNode[]{list1, list2, list3};

        Solution solution = new Solution();
        Solution.ListNode output = solution.mergeKLists(lists);

        assertEquals(1, output.val);
        output = output.next;
        assertEquals(1, output.val);
        output = output.next;
        assertEquals(2, output.val);
        output = output.next;
        assertEquals(3, output.val);
        output = output.next;
        assertEquals(4, output.val);
        output = output.next;
        assertEquals(4, output.val);
        output = output.next;
        assertEquals(5, output.val);
        output = output.next;
        assertEquals(6, output.val);

    }

    /*
    Input: lists = []
    Output: []
     */
    @Test
    public void TestCase2() {
        Solution.ListNode[] lists = new Solution.ListNode[0];

        Solution solution = new Solution();
        Solution.ListNode output = solution.mergeKLists(lists);

        assertEquals(null, output);
    }

    /*
    Input: lists = [[]]
    Output: []
     */
    @Test
    public void TestCase3() {
        Solution.ListNode list1 = new Solution.ListNode();
        Solution.ListNode[] lists = new Solution.ListNode[1];
        lists[0] = list1;

        Solution solution = new Solution();
        Solution.ListNode output = solution.mergeKLists(lists);

        assertEquals(0, output.val);
    }
}
