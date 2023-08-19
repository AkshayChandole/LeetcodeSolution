package Backtracking.LetterCombinationsOfPhoneNumber;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    /*
    Input: digits = "23"
    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     */
    @Test
    public void TestCase1() {
        String digits = "23";
        List<String> expectedResult = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");

        evaluateSolution(digits, expectedResult);
    }

    /*
    Input: digits = ""
    Output: []
     */
    @Test
    public void TestCase2() {
        String digits = "";
        List<String> expectedResult = Arrays.asList();

        evaluateSolution(digits, expectedResult);
    }

    /*
    Input: digits = "2"
    Output: ["a","b","c"]
     */
    @Test
    public void TestCase3() {
        String digits = "2";
        List<String> expectedResult = Arrays.asList("a", "b", "c");

        evaluateSolution(digits, expectedResult);
    }

    private void evaluateSolution(String digits, List<String> expectedResult) {
        Solution solution = new Solution();
        var actualResult = solution.letterCombinations(digits);

        assertEquals(expectedResult, actualResult);
    }
}
