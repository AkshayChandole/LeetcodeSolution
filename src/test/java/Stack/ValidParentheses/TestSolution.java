package Stack.ValidParentheses;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    @Test
    public void TestCase1(){
        String s = "()";
        boolean expectedResult = true;
        evaluateSolution(s, expectedResult);
    }

    @Test
    public void TestCase2(){
        String s = "()[]{}";
        boolean expectedResult = true;
        evaluateSolution(s, expectedResult);
    }

    @Test
    public void TestCase3(){
        String s = "(]";
        boolean expectedResult = false;
        evaluateSolution(s, expectedResult);
    }

    @Test
    public void TestCase4(){
        String s = "([)]";
        boolean expectedResult = false;
        evaluateSolution(s, expectedResult);
    }
    private void evaluateSolution(String s, boolean expectedResult) {
        Solution solution = new Solution();
        boolean actualResult = solution.isValid(s);
        assertEquals(expectedResult, actualResult);
    }
}
