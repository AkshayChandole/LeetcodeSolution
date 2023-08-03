package BinarySearch.KokoEatingBananas;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSolution {
    /*
    Input: piles = [3,6,7,11], h = 8
    Output: 4
     */
    @Test
    public void TestCase1() {
        int[] piles = new int[]{3, 6, 7, 11};
        int h = 8;
        int expectedResult = 4;
        evaluateSolution(piles, h, expectedResult);
    }

    /*
    Input: piles = [30,11,23,4,20], h = 5
    Output: 30
     */
    @Test
    public void TestCase2() {
        int[] piles = new int[]{30, 11, 23, 4, 20};
        int h = 5;
        int expectedResult = 30;
        evaluateSolution(piles, h, expectedResult);
    }

    /*
    Input: piles = [30,11,23,4,20], h = 6
    Output: 23
     */
    @Test
    public void TestCase3() {
        int[] piles = new int[]{30, 11, 23, 4, 20};
        int h = 6;
        int expectedResult = 23;
        evaluateSolution(piles, h, expectedResult);
    }

    private void evaluateSolution(int[] piles, int h, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.minEatingSpeed(piles, h);
        assertEquals(expectedResult, actualResult);
    }
}
