package String.ReverseWordsInAString;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    @Test
    public void TestCase1() {
        String s = "the sky is blue";
        String expectedResult = "blue is sky the";
        evaluateSolution(s, expectedResult);
    }

    @Test
    public void TestCase2() {
        String s = "  hello world  ";
        String expectedResult = "world hello";
        evaluateSolution(s, expectedResult);
    }

    @Test
    public void TestCase3() {
        String s = "a good   example";
        String expectedResult = "example good a";
        evaluateSolution(s, expectedResult);
    }

    private void evaluateSolution(String s, String expectedResult) {
        Solution solution = new Solution();
        String actualResult = solution.reverseWords(s);
        assertEquals(expectedResult, actualResult);
    }
}
