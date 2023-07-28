package LinkedList.CopyListWithRandomPointer;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSolution {
    /*
    Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
    Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
     */
    @Test
    public void TestCase1() {
        Solution.Node head = new Solution.Node(7);
        Solution.Node node1 = new Solution.Node(13);
        Solution.Node node2 = new Solution.Node(11);
        Solution.Node node3 = new Solution.Node(10);
        Solution.Node node4 = new Solution.Node(1);
        head.next = node1;
        head.random = null;
        node1.next = node2;
        node1.random = head;
        node2.next = node3;
        node2.random = node4;
        node3.next = node4;
        node3.random = node2;
        node4.next = null;
        node4.random = head;

        evaluateSolution(head);
    }

    /*
    Input: head = [[1,1],[2,1]]
    Output: [[1,1],[2,1]]
     */
    @Test
    public void TestCase2() {
        Solution.Node head = new Solution.Node(1);
        Solution.Node node1 = new Solution.Node(2);
        head.next = node1;
        head.random = node1;
        node1.next = null;
        node1.random = node1;

        evaluateSolution(head);
    }

    /*
    Input: head = [[3,null],[3,0],[3,null]]
    Output: [[3,null],[3,0],[3,null]]
     */
    @Test
    public void TestCase3() {
        Solution.Node head = new Solution.Node(3);
        Solution.Node node1 = new Solution.Node(3);
        Solution.Node node2 = new Solution.Node(3);
        head.next = node1;
        head.random = null;
        node1.next = node2;
        node1.random = head;
        node1.next = null;
        node1.random = null;

        evaluateSolution(head);
    }

    private void evaluateSolution(Solution.Node head) {
        Solution solution = new Solution();
        Solution.Node output = solution.copyRandomList(head);

        while (head != null && output != null) {
            assertEquals(head.val, output.val);
            if (head.next != null && output.next != null) {
                assertEquals(head.next.val, output.next.val);
            }
            if (head.random != null && output.random != null) {
                assertEquals(head.random.val, output.random.val);
            }
            head = head.next;
            output = output.next;
        }
    }
}
