package DynamicProgramming.DecodeWays;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    /*
    Input: s = "12"
    Output: 2
     */
    @Test
    public void TestCase1() {
        String s = "12";
        int expectedResult = 2;

        evaluateSolution(s, expectedResult);
    }

    /*
    Input: s = "226"
    Output: 3
     */
    @Test
    public void TestCase2() {
        String s = "226";
        int expectedResult = 3;

        evaluateSolution(s, expectedResult);
    }

    /*
    Input: s = "06"
    Output: 0
     */
    @Test
    public void TestCase3() {
        String s = "06";
        int expectedResult = 0;

        evaluateSolution(s, expectedResult);
    }

    private void evaluateSolution(String s, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.numDecodings(s);

        assertEquals(expectedResult, actualResult);
    }
}
