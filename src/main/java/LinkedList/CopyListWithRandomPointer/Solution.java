package LinkedList.CopyListWithRandomPointer;


import java.util.HashMap;

// ****************************************************************
// Optimal Solution -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
class Solution {
    public Node copyRandomList(Node head) {
        Node tempNode = head;

        // we will create each node and link it next to the original nodes
        while (tempNode != null) {
            Node newNode = new Node(tempNode.val);
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            tempNode = tempNode.next.next;
        }

        // Take a pointer, say itr, point it to the head of the list.
        // This will help us to point random pointers as per the original list.
        // This can be achieved by itr->next->random = itr->random->next

        Node itr = head;
        while (itr != null) {
            if (itr.random != null) {
                itr.next.random = itr.random.next;
            }
            itr = itr.next.next;
        }

        // Use three pointers.
        // One dummy node whose next node points to the first deep node.
        // itr pointer at the head of the original list and
        // fast which is two steps ahead of the itr.
        // This will be used to separate the original linked list with the deep nodes list.
        Node dummy = new Node(-1);
        itr = head;
        tempNode = dummy;
        Node fast;
        while (itr != null) {
            fast = itr.next.next;
            tempNode.next = itr.next;
            itr.next = fast;
            tempNode = tempNode.next;
            itr = fast;
        }

        return dummy.next;
    }

    // Definition for a Node.
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

// ****************************************************************
// Brute Force Approach -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
class Solution1 {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node tempNode = head;

        //first iteration for inserting deep nodes of every node in the hashmap.
        while (tempNode != null) {
            Node newNode = new Node(tempNode.val);
            map.put(tempNode, newNode);
            tempNode = tempNode.next;
        }

        tempNode = head;
        //second iteration for linking next and random pointer
        while (tempNode != null) {
            Node currentNewNode = map.get(tempNode);
            currentNewNode.next = (tempNode.next != null) ? map.get(tempNode.next) : null;
            currentNewNode.random = (tempNode.random != null) ? map.get(tempNode.random) : null;
            tempNode = tempNode.next;
        }

        return map.get(head);
    }

    // Definition for a Node.
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}