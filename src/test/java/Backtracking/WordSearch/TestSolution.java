package Backtracking.WordSearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    Output: true
     */
    @Test
    public void TestCase1() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean expectedResult = true;

        evaluateSolution(board, word, expectedResult);
    }

    /*
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
    Output: true
     */
    @Test
    public void TestCase2() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "SEE";
        boolean expectedResult = true;

        evaluateSolution(board, word, expectedResult);
    }

    /*
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
    Output: false
     */
    @Test
    public void TestCase3() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        boolean expectedResult = false;

        evaluateSolution(board, word, expectedResult);
    }

    private void evaluateSolution(char[][] board, String word, boolean expectedResult) {
        Solution solution = new Solution();
        boolean actaulResult = solution.exist(board, word);

        assertEquals(expectedResult, actaulResult);
    }
}
