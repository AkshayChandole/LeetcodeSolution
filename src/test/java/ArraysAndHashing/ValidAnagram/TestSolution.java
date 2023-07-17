package ArraysAndHashing.ValidAnagram;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSolution {
    @Test
    public void TestCase1() {
        String s = "anagram";
        String t = "nagaram";
        boolean expectedAnswer = true;
        evaluateSolution(s, t, expectedAnswer);
    }

    @Test
    public void TestCase2() {
        String s = "rat";
        String t = "car";
        boolean expectedAnswer = false;
        evaluateSolution(s, t, expectedAnswer);
    }

    private void evaluateSolution(String s, String t, boolean expectedAnswer) {
        Solution solution = new Solution();
        boolean actualResult = solution.isAnagram(s, t);
        assertEquals(expectedAnswer, actualResult);
    }
}
