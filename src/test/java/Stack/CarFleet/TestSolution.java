package Stack.CarFleet;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSolution {
    @Test
    public void TestCase1() {
        int target = 12;
        int[] position = new int[]{10, 8, 0, 5, 3};
        int[] speed = new int[]{2, 4, 1, 1, 3};
        int expectedResult = 3;
        evaluateSolution(target, position, speed, expectedResult);
    }

    @Test
    public void TestCase2() {
        int target = 10;
        int[] position = new int[]{3};
        int[] speed = new int[]{3};
        int expectedResult = 1;
        evaluateSolution(target, position, speed, expectedResult);
    }

    @Test
    public void TestCase3() {
        int target = 100;
        int[] position = new int[]{0, 2, 4};
        int[] speed = new int[]{4, 2, 1};
        int expectedResult = 1;
        evaluateSolution(target, position, speed, expectedResult);
    }

    private void evaluateSolution(int target, int[] position, int[] speed, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.carFleet(target, position, speed);
        assertEquals(expectedResult, actualResult);
    }
}
