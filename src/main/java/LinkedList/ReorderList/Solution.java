package LinkedList.ReorderList;

/**
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode middleNode = findMiddleNode(head);
        ListNode reversedSecondHalf = reverse(middleNode.next);
        middleNode.next = null;

        // Join two linked-lists firstHalf and secondHalf taking 1-1 node from each
        ListNode firstHalf = head;
        ListNode secondHalf = reversedSecondHalf;

        ListNode nodeFromFirstHalf = null;
        ListNode nodeFromSecondHalf = null;

        while (firstHalf != null && secondHalf != null) {
            nodeFromFirstHalf = firstHalf.next;
            nodeFromSecondHalf = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = nodeFromFirstHalf;

            firstHalf = nodeFromFirstHalf;
            secondHalf = nodeFromSecondHalf;
        }
    }


    private ListNode findMiddleNode(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;

        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        return slowNode;
    }

    private ListNode reverse(ListNode head) {
        ListNode currentNode = head;
        ListNode previousNode = null;
        ListNode nextNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return previousNode;
    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}