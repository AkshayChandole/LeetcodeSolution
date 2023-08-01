package LinkedList.ReverseNodesInKGroup;

/**
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        int count = 0;
        ListNode currentNode = dummyNode;
        ListNode nextNode = dummyNode;
        ListNode previousNode = dummyNode;

        // Calculate size of linked list
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            count++;
        }

        // Reverse each group separately
        while (count >= k) {
            currentNode = previousNode.next;
            nextNode = currentNode.next;
            for (int i = 1; i < k; i++) {
                currentNode.next = nextNode.next;
                nextNode.next = previousNode.next;
                previousNode.next = nextNode;
                nextNode = currentNode.next;
            }
            previousNode = currentNode;
            count -= k;
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





