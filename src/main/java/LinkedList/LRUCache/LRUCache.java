package LinkedList.LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


// ***************************************************************************
// Optimal Solution using doubly-linked list and hashmap -

/**
 * Time Complexity for put operation - O(1)
 * Time Complexity for get operation - O(1)
 * Space Complexity - O(n)
 */
public class LRUCache {
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    Map<Integer, Node> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.nextNode = tail;
        tail.nextNode = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.previousNode);
        }
        insert(new Node(key, value));
    }

    private void insert(Node node) {
        map.put(node.key, node);
        node.nextNode = head.nextNode;
        node.nextNode.previousNode = node;
        head.nextNode = node;
        node.previousNode = head;
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.previousNode.nextNode = node.nextNode;
        node.nextNode.previousNode = node.previousNode;
    }

    class Node {
        Node previousNode, nextNode;
        int key, value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
