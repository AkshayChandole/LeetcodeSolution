package DynamicProgramming.LongestPalindromicSubstring;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    /*
    Input: s = "babad"
    Output: "bab"
     */
    @Test
    public void TestCase1() {
        String s = "babad";
        String expectedResult = "bab";

        evaluateSolution(s, expectedResult);
    }

    /*
    Input: s = "cbbd"
    Output: "bb"
     */
    @Test
    public void TestCase2() {
        String s = "cbbd";
        String expectedResult = "bb";

        evaluateSolution(s, expectedResult);
    }

    private void evaluateSolution(String s, String expectedResult) {
        Solution solution = new Solution();
        String actualResult = solution.longestPalindrome(s);

        assertEquals(expectedResult, actualResult);
    }
}
