package Backtracking.PalindromePartitioning;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    /*
    Input: s = "aab"
    Output: [["a","a","b"],["aa","b"]]
     */
    @Test
    public void TestCase1() {
        String s = "aab";
        List<List<String>> expectedResult = Arrays.asList(Arrays.asList("a", "a", "b"), Arrays.asList("aa", "b"));

        evaluateSolution(s, expectedResult);
    }

    /*
    Input: s = "a"
    Output: [["a"]]
     */
    @Test
    public void TestCase2() {
        String s = "a";
        List<List<String>> expectedResult = Arrays.asList(Arrays.asList("a"));

        evaluateSolution(s, expectedResult);
    }

    private void evaluateSolution(String s, List<List<String>> expectedResult) {
        Solution solution = new Solution();
        var actualResult = solution.partition(s);

        assertEquals(expectedResult, actualResult);
    }
}
