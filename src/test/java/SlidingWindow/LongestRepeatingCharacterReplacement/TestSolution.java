package SlidingWindow.LongestRepeatingCharacterReplacement;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSolution {
    @Test
    public void TestCase1() {
        String s = "ABAB";
        int k = 2;
        int expectedResult = 4;
        evaluateSolution(s, k, expectedResult);
    }

    @Test
    public void TestCase2() {
        String s = "AABABBA";
        int k = 1;
        int expectedResult = 4;
        evaluateSolution(s, k, expectedResult);
    }

    private void evaluateSolution(String s, int k, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.characterReplacement(s, k);
        assertEquals(expectedResult, actualResult);
    }
}
