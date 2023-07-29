package LinkedList.AddTwoNumbers;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSolution {
    /*
    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    */
    @Test
    public void TestCase1() {
        Solution.ListNode l1 = new Solution.ListNode(3);
        l1 = new Solution.ListNode(4, l1);
        l1 = new Solution.ListNode(2, l1);

        Solution.ListNode l2 = new Solution.ListNode(4);
        l2 = new Solution.ListNode(6, l2);
        l2 = new Solution.ListNode(5, l2);

        Solution.ListNode expectedResult = new Solution.ListNode(8);
        expectedResult = new Solution.ListNode(0, expectedResult);
        expectedResult = new Solution.ListNode(7, expectedResult);

        evaluateSolution(l1, l2, expectedResult);
    }

    /*
    Input: l1 = [0], l2 = [0]
    Output: [0]
     */
    @Test
    public void TestCase2() {
        Solution.ListNode l1 = new Solution.ListNode(0);

        Solution.ListNode l2 = new Solution.ListNode(0);

        Solution.ListNode expectedResult = new Solution.ListNode(0);

        evaluateSolution(l1, l2, expectedResult);
    }

    /*
    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]
     */
    @Test
    public void TestCase3() {
        Solution.ListNode l1 = new Solution.ListNode(9);
        l1 = new Solution.ListNode(9, l1);
        l1 = new Solution.ListNode(9, l1);
        l1 = new Solution.ListNode(9, l1);
        l1 = new Solution.ListNode(9, l1);
        l1 = new Solution.ListNode(9, l1);
        l1 = new Solution.ListNode(9, l1);

        Solution.ListNode l2 = new Solution.ListNode(9);
        l2 = new Solution.ListNode(9, l2);
        l2 = new Solution.ListNode(9, l2);
        l2 = new Solution.ListNode(9, l2);

        Solution.ListNode expectedResult = new Solution.ListNode(1);
        expectedResult = new Solution.ListNode(0, expectedResult);
        expectedResult = new Solution.ListNode(0, expectedResult);
        expectedResult = new Solution.ListNode(0, expectedResult);
        expectedResult = new Solution.ListNode(9, expectedResult);
        expectedResult = new Solution.ListNode(9, expectedResult);
        expectedResult = new Solution.ListNode(9, expectedResult);
        expectedResult = new Solution.ListNode(8, expectedResult);

        evaluateSolution(l1, l2, expectedResult);
    }

    private void evaluateSolution(Solution.ListNode l1, Solution.ListNode l2, Solution.ListNode expectedResult) {
        Solution solution = new Solution();
        Solution.ListNode actualResult = solution.addTwoNumbers(l1, l2);

        while (actualResult != null && expectedResult != null) {
            assertEquals(expectedResult.val, actualResult.val);
            expectedResult = expectedResult.next;
            actualResult = actualResult.next;
        }
    }
}
