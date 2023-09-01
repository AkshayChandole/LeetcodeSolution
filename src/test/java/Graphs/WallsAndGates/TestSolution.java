package Graphs.WallsAndGates;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestSolution {

    /*
    Example 1:
        Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
        Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
     */
    @Test
    public void TestCase1() {
        int[][] rooms = {{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1}, {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}};

        Solution solution = new Solution();
        solution.wallsAndGates(rooms);

        int[][] expected = {{3, -1, 0, 1}, {2, 2, 1, -1}, {1, -1, 2, -1}, {0, -1, 3, 4}};

        for (int i = 0; i < rooms.length; i++) {
            assertArrayEquals(expected[i], rooms[i]);
        }
    }

    /*
    Example 2:
        Input: rooms = [[-1]]
        Output: [[-1]]
    */
    @Test
    public void TestCase2() {
        int[][] rooms = {{-1}};

        Solution solution = new Solution();
        solution.wallsAndGates(rooms);

        int[][] expected = {{-1}};

        for (int i = 0; i < rooms.length; i++) {
            assertArrayEquals(expected[i], rooms[i]);
        }
    }
}
