package DynamicProgramming.MinCostClimbingStairs;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    /*
    Input: cost = [10,15,20]
    Output: 15
     */
    @Test
    public void TestCase1() {
        int[] cost = {10, 15, 20};
        int expectedResult = 15;

        evaluateSolution(cost, expectedResult);
    }

    /*
    Input: cost = [1,100,1,1,1,100,1,1,100,1]
    Output: 6
     */
    @Test
    public void TestCase2() {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int expectedResult = 6;

        evaluateSolution(cost, expectedResult);
    }

    private void evaluateSolution(int[] cost, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.minCostClimbingStairs(cost);

        assertEquals(expectedResult, actualResult);
    }
}
