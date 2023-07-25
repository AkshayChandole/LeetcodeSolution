package Stack.EvaluateReversePolishNotation;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSolution {
    @Test
    public void TestCase1() {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        int expectedResult = 9;
        evaluateSolution(tokens, expectedResult);
    }

    @Test
    public void TestCase2() {
        String[] tokens = new String[]{"4", "13", "5", "/", "+"};
        int expectedResult = 6;
        evaluateSolution(tokens, expectedResult);
    }

    @Test
    public void TestCase3() {
        String[] tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int expectedResult = 22;
        evaluateSolution(tokens, expectedResult);
    }

    private void evaluateSolution(String[] tokens, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.evalRPN(tokens);
        assertEquals(expectedResult, actualResult);
    }


}
