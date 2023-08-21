package DynamicProgramming.PalindromicSubstrings;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    /*
    Input: s = "abc"
    Output: 3
     */
    @Test
    public void TestCase1() {
        String s = "abc";
        int expectedResult = 3;

        evaluateSolution(s, expectedResult);
    }

    /*
    Input: s = "aaa"
    Output: 6
     */
    @Test
    public void TestCase2() {
        String s = "aaa";
        int expectedResult = 6;

        evaluateSolution(s, expectedResult);
    }

    private void evaluateSolution(String s, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.countSubstrings(s);

        assertEquals(expectedResult, actualResult);
    }
}
