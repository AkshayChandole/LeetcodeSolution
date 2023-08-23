package DynamicProgramming.CoinChange;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    /*
    Input: coins = [1,2,5], amount = 11
    Output: 3
     */
    @Test
    public void TestCase1() {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int expectedResult = 3;

        evaluateSolution(coins, amount, expectedResult);
    }


    /*
    Input: coins = [2], amount = 3
    Output: -1
     */
    @Test
    public void TestCase2() {
        int[] coins = {2};
        int amount = 3;
        int expectedResult = -1;

        evaluateSolution(coins, amount, expectedResult);
    }

    /*
    Input: coins = [1], amount = 0
    Output: 0
     */
    @Test
    public void TestCase3() {
        int[] coins = {1};
        int amount = 0;
        int expectedResult = 0;

        evaluateSolution(coins, amount, expectedResult);
    }

    private void evaluateSolution(int[] coins, int amount, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.coinChange(coins, amount);

        assertEquals(expectedResult, actualResult);
    }
}
