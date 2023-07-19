package TwoPointers.ValidPalindrome;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSolution {
    @Test
    public void TestCase1() {
        String s = "A man, a plan, a canal: Panama";
        boolean expectedResult = true;
        evaluateSolution(s, expectedResult);
    }

    @Test
    public void TestCase2() {
        String s = "race a car";
        boolean expectedResult = false;
        evaluateSolution(s, expectedResult);
    }

    @Test
    public void TestCase3() {
        String s = " ";
        boolean expectedResult = true;
        evaluateSolution(s, expectedResult);
    }

    private void evaluateSolution(String s, boolean expectedResult) {
        Solution solution = new Solution();
        boolean actualResult = solution.isPalindrome(s);
        assertEquals(expectedResult, actualResult);
    }
}
