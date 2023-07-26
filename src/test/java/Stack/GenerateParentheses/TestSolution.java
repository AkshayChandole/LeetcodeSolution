package Stack.GenerateParentheses;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TestSolution {
    @Test
    public void TestCase1() {
        int n = 3;
        List<String> expectedResult = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
        evaluateSolution(n, expectedResult);
    }

    @Test
    public void TestCase2() {
        int n = 1;
        List<String> expectedResult = Arrays.asList("()");
        evaluateSolution(n, expectedResult);
    }

    private void evaluateSolution(int n, List<String> expectedResult) {
        Solution solution = new Solution();
        List<String> actualResult = solution.generateParenthesis(n);
        assertEquals(expectedResult, actualResult);
    }
}
