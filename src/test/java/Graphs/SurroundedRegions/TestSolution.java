package Graphs.SurroundedRegions;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestSolution {
    /*
    Example 1:
        Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
        Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
     */
    @Test
    public void TestCase1() {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        char[][] expectedResult = {{'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'O', 'X', 'X'}};

        evaluateSolution(board, expectedResult);
    }

    /*
    Example 2:
        Input: board = [["X"]]
        Output: [["X"]]
     */
    @Test
    public void TestCase2() {
        char[][] board = {{'X'}};
        char[][] expectedResult = {{'X'}};

        evaluateSolution(board, expectedResult);
    }

    private void evaluateSolution(char[][] board, char[][] expectedResult) {
        Solution solution = new Solution();
        solution.solve(board);

        assertArrayEquals(expectedResult, board);
    }
}
