package DynamicProgramming.ClimbingStairs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: n = 2
    Output: 2
     */
    @Test
    public void TestCase1() {
        int n = 2;
        int expectedResult = 2;

        evaluateSolution(n, expectedResult);
    }

    /*
    Input: n = 3
    Output: 3
     */
    @Test
    public void TestCase2() {
        int n = 3;
        int expectedResult = 3;

        evaluateSolution(n, expectedResult);
    }

    private void evaluateSolution(int n, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.climbStairs(n);

        assertEquals(expectedResult, actualResult);
    }
}
