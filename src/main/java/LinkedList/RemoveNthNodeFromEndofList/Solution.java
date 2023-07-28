package LinkedList.RemoveNthNodeFromEndofList;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// *********************************************************************
// Optimal Solution using Two Pointers Approach -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }

        ListNode tempNode = new ListNode(-1);
        ListNode previousNode = tempNode;
        tempNode.next = head;

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (n > 0) {
            fastPointer = fastPointer.next;
            n--;
        }

        while (fastPointer != null) {
            slowPointer = slowPointer.next;
            previousNode = previousNode.next;
            fastPointer = fastPointer.next;
        }

        previousNode.next = slowPointer.next;

        return tempNode.next;
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

// *********************************************************************
// Better Solution using Stack -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }

        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode tempNode = new ListNode(-1);
        tempNode.next = head;
        ListNode currentNode = tempNode;

        while (currentNode != null) {
            stack.push(currentNode);
            stack.add(currentNode);
            currentNode = currentNode.next;
        }

        while (n > 0) {
            stack.pop();
            n--;
        }

        currentNode = stack.peek();
        currentNode.next = currentNode.next.next;

        return tempNode.next;
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

// *********************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }

        List<ListNode> nodeList = new ArrayList<>();
        ListNode currentNode = head;
        int size = 0;

        while (currentNode != null) {
            nodeList.add(currentNode);
            size++;
            currentNode = currentNode.next;
        }

        if (n == size) {
            return head.next;
        } else if (n == 1) {
            currentNode = nodeList.get(size - 2);
            currentNode.next = null;
        } else {
            currentNode = nodeList.get(size - n - 1);
            currentNode.next = currentNode.next.next;
        }

        return head;
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