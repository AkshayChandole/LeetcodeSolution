package LinkedList.AddTwoNumbers;

// *************************************************************************************
// Recursive Approach -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
public class Solution {

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        return addNode(l1, l2, 0);
    }

    public static ListNode addNode(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        if (l1 != null) {
            carry += l1.val;
            l1 = l1.next;
        }

        if (l2 != null) {
            carry += l2.val;
            l2 = l2.next;
        }

        ListNode addNode = new ListNode(carry % 10);
        carry = carry / 10;
        addNode.next = addNode(l1, l2, carry);
        return addNode;
    }


    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


// *************************************************************************************
// Iterative Approach -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode pNode = dummyNode;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            pNode.next = new ListNode(sum % 10);
            pNode = pNode.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            pNode.next = new ListNode(carry);
        }

        return dummyNode.next;
    }


    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
