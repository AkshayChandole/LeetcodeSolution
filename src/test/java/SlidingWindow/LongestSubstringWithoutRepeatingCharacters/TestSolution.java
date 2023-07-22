package SlidingWindow.LongestSubstringWithoutRepeatingCharacters;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    @Test
    public void TestCase1() {
        String s = "abcabcbb";
        int expectedResult = 3;
        evaluateSolution(s, expectedResult);
    }

    @Test
    public void TestCase2() {
        String s = "bbbbb";
        int expectedResult = 1;
        evaluateSolution(s, expectedResult);
    }

    @Test
    public void TestCase3() {
        String s = "pwwkew";
        int expectedResult = 3;
        evaluateSolution(s, expectedResult);
    }

    private void evaluateSolution(String s, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.lengthOfLongestSubstring(s);
        assertEquals(expectedResult, actualResult);
    }
}
