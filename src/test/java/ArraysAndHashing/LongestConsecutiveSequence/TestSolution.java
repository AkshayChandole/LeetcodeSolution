package ArraysAndHashing.LongestConsecutiveSequence;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class TestSolution {

    @Test
    public void TestCase1() {
        int[] numbers = new int[]{100, 4, 200, 1, 3, 2};
        int expectedAnswer = 4;
        evaluateResult(numbers, expectedAnswer);
    }

    @Test
    public void TestCase2() {
        int[] numbers = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int expectedAnswer = 9;
        evaluateResult(numbers, expectedAnswer);
    }

    private void evaluateResult(int[] numbers, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.longestConsecutive(numbers);
        assertEquals(expectedResult, actualResult);
    }
}
