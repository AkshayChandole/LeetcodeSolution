package Stack.DailyTemperatures;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestSolution {
    @Test
    public void TestCase1() {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] expectedResult = new int[]{1, 1, 4, 2, 1, 1, 0, 0};
        evaluateSolution(temperatures, expectedResult);
    }

    @Test
    public void TestCase2() {
        int[] temperatures = new int[]{30, 40, 50, 60};
        int[] expectedResult = new int[]{1, 1, 1, 0};
        evaluateSolution(temperatures, expectedResult);
    }

    @Test
    public void TestCase3() {
        int[] temperatures = new int[]{30, 60, 90};
        int[] expectedResult = new int[]{1, 1, 0};
        evaluateSolution(temperatures, expectedResult);
    }

    private void evaluateSolution(int[] temperatures, int[] expectedResult) {
        Solution solution = new Solution();
        int[] actualResult = solution.dailyTemperatures(temperatures);
        assertArrayEquals(expectedResult, actualResult);

    }
}
