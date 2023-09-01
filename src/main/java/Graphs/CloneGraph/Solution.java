package Graphs.CloneGraph;

import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


// ***********************************************************************
// Optimal Solution using Breadth first search (BFS) -

/**
 * Time Complexity - O(N), where N is the number of nodes in the graph. Every node is processed once.
 * Space Complexity - O(N) due to the space needed to store the mapping and for BFS queue.
 */
public class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }

        // Hash map to save the visited node, and it's respective clone as key and value respectively. This helps to avoid cycles.
        Map<Node, Node> visited = new HashMap<>();

        // Put the first node in the queue
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        // Clone the node and put it in the visited map
        visited.put(node, new Node(node.val, new ArrayList<>()));

        // Start BFS traversal
        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();

            for(Node neighbor : currentNode.neighbors) {
                // Clone the neighbor and put in the visited, if not present already
                if(!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }

                // Attach the clone of the neighbor to the current node's clone
                visited.get(currentNode).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }
}


// ***********************************************************************
// Brute Force Solution using Depth first search (DFS) -

/**
 * Time Complexity - O(N), where N is the number of nodes in the graph. Every node is processed once.
 * Space Complexity - O(N) due to the space needed to store the mapping and for the recursion stack.
 */
class Solution1 {
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }

        // if node is already visited, then return its clone.
        if(visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a clone for given node.
        Node cloneNode = new Node(node.val, new ArrayList<>());
        visited.put(node, cloneNode);

        // Iterate over the neighbors and clone them.
        for(Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }
}
