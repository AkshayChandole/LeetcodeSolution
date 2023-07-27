package LinkedList.ReverseLinkedList;

public class Solution {
    //**************************************************************************
    //Iterative version
    public ListNode reverseList(ListNode head) {
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

    //**************************************************************************
    //Recursive version
    public ListNode reverseList1(ListNode head) {
        return reverseNodes(head, null);
    }

    private ListNode reverseNodes(ListNode first, ListNode second) {
        if (first == null) return second;
        ListNode temporaryNode = first.next;
        first.next = second;
        return reverseNodes(temporaryNode, first);
    }

    //**************************************************************************
    // Definition for singly-linked list.
    static class ListNode {
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
