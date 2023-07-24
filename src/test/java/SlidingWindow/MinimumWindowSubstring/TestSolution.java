package SlidingWindow.MinimumWindowSubstring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    @Test
    public void TestCase1() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String expectedResult = "BANC";
        evaluateSolution(s, t, expectedResult);
    }

    @Test
    public void TestCase2() {
        String s = "a";
        String t = "a";
        String expectedResult = "a";
        evaluateSolution(s, t, expectedResult);
    }

    @Test
    public void TestCase3() {
        String s = "a";
        String t = "aa";
        String expectedResult = "";
        evaluateSolution(s, t, expectedResult);
    }

    private void evaluateSolution(String s, String t, String expectedResult) {
        Solution solution = new Solution();
        String actualResult = solution.minWindow(s, t);
        assertEquals(expectedResult, actualResult);
    }
}
