package LinkedList.MergeKSortedLists;

import java.util.PriorityQueue;

// ********************************************************************
// Optimal Solution using Min map -

/**
 * Time Complexity - O(N*logK) where "K" is the number of linked lists in the array and “N” is the number of nodes
 * Space Complexity - O(1)
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            current.next = node;
            current = current.next;

            if (node.next != null) {
                queue.offer(node.next);
            }
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

// ********************************************************************
// Better Solution using Divide and Conquer algorithm -

/**
 * Time Complexity - O(N*logK) where “logK” is because we are dividing the linked list into 2 i.e k/2, k/4 in each level of recursion so in total we are doing it logK times, “N” is the total number of nodes
 * Space Complexity - O(1)
 */
class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);

    }

    private ListNode partition(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }

        if (start < end) {
            int mid = start + (end - start) / 2;
            ListNode l1 = partition(lists, start, mid);
            ListNode l2 = partition(lists, mid + 1, end);

            return merge(l1, l2);
        } else {
            return null;
        }
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
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

// ********************************************************************
// Brute force solution -

/**
 * Time Complexity - O(K*N) where “K” is the number of linked lists in the array and “N” is the number of nodes
 * Space Complexity -O(1)
 */
class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyNode = new ListNode(0);

        for (ListNode list : lists) {
            dummyNode.next = merge(dummyNode.next, list);
        }

        return dummyNode.next;
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode tempNode = new ListNode(0);
        ListNode tail = tempNode;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 == null) {
            tail.next = list2;
        } else {
            tail.next = list1;
        }

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
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
