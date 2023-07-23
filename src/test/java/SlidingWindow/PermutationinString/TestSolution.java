package SlidingWindow.PermutationinString;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    @Test
    public void TestCase1(){
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean expectedResult = true;
        evaluateSolution(s1,s2,expectedResult);
    }

    @Test
    public void TestCase2(){
        String s1 = "ab";
        String s2 = "eidboaoo";
        boolean expectedResult = false;
        evaluateSolution(s1,s2,expectedResult);
    }

    private void evaluateSolution(String s1, String s2, boolean expectedResult) {
        Solution solution = new Solution();
        boolean actualResult = solution.checkInclusion(s1,s2);
        assertEquals(expectedResult, actualResult);
    }
}
