package Backtracking.N_Queens;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    /*
    Input: n = 4
    Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
     */
    @Test
    public void TestCase1() {
        int n = 4;
        List<List<String>> expectedResult = Arrays.asList(Arrays.asList(".Q..", "...Q", "Q...", "..Q."), Arrays.asList("..Q.", "Q...", "...Q", ".Q.."));

        evaluateSolution(n, expectedResult);
    }

    /*
    Input: n = 1
    Output: [["Q"]]
     */
    @Test
    public void TestCase2() {
        int n = 1;
        List<List<String>> expectedResult = Arrays.asList(Arrays.asList("Q"));

        evaluateSolution(n, expectedResult);
    }

    private void evaluateSolution(int n, List<List<String>> expectedResult) {
        Solution solution = new Solution();
        var actualResult = solution.solveNQueens(n);

        assertEquals(expectedResult, actualResult);
    }
}
