package Graphs.CloneGraph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class TestSolution {
    /*
    Example 1:
        Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
        Output: [[2,4],[1,3],[2,4],[1,3]]
     */
    @Test
    public void TestCase1() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);

        Solution cloner = new Solution();
        Node clonedNode1 = cloner.cloneGraph(node1);

        assertEquals(node1.val, clonedNode1.val);
        assertEquals(node1.neighbors.size(), clonedNode1.neighbors.size());

        assertNotSame(node1, clonedNode1);
        assertNotSame(node1.neighbors.get(0), clonedNode1.neighbors.get(0));
    }

    /*
    Example 2:
        Input: adjList = [[]]
        Output: [[]]
     */
    @Test
    public void TestCase2() {
        Node node1 = new Node();

        node1.neighbors = new ArrayList<>();

        Solution cloner = new Solution();
        Node clonedNode1 = cloner.cloneGraph(node1);

        assertEquals(node1.val, clonedNode1.val);
        assertEquals(node1.neighbors.size(), clonedNode1.neighbors.size());

        assertNotSame(node1, clonedNode1);
    }
}
