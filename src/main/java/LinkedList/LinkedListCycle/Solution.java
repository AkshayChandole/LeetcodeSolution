package LinkedList.LinkedListCycle;

import java.util.HashSet;

// ****************************************************************
// Optimal Solution using Two Pointers Approach -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slowNode = head;
        ListNode fastNode = head;

        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                return true;
            }
        }
        return false;
    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

// ****************************************************************
// Brute Force Solution using HashSet -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
class Solution1 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        HashSet<ListNode> hastSet = new HashSet<>();

        while (head != null) {
            if (hastSet.contains(head)) {
                return true;
            }
            hastSet.add(head);
            head = head.next;
        }

        return false;
    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}