package DynamicProgramming.WordBreak;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: s = "leetcode", wordDict = ["leet","code"]
    Output: true
     */
    @Test
    public void TestCase1() {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet","code");
        boolean expectedResult = true;

        evaluateSolution(s, wordDict, expectedResult);
    }

    /*
    Input: s = "applepenapple", wordDict = ["apple","pen"]
    Output: true
     */
    @Test
    public void TestCase2() {
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple","pen");
        boolean expectedResult = true;

        evaluateSolution(s, wordDict, expectedResult);
    }

    /*
    Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
    Output: false
     */
    @Test
    public void TestCase3() {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats","dog","sand","and","cat");
        boolean expectedResult = false;

        evaluateSolution(s, wordDict, expectedResult);
    }

    private void evaluateSolution(String s, List<String> wordDict, boolean expectedResult) {
        Solution solution = new Solution();
        boolean actualResult = solution.wordBreak(s, wordDict);

        assertEquals(expectedResult, actualResult);
    }
}
