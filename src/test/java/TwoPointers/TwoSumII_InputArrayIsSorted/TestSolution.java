package TwoPointers.TwoSumII_InputArrayIsSorted;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestSolution {
    @Test
    public void TestCase1(){
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] expectedResult = new int[]{1,2};
        evaluateSolution(numbers, target, expectedResult);
    }

    @Test
    public void TestCase2(){
        int[] numbers = new int[]{2,3,4};
        int target = 6;
        int[] expectedResult = new int[]{1,3};
        evaluateSolution(numbers, target, expectedResult);
    }

    @Test
    public void TestCase3(){
        int[] numbers = new int[]{-1,0};
        int target = -1;
        int[] expectedResult = new int[]{1,2};
        evaluateSolution(numbers, target, expectedResult);
    }

    private void evaluateSolution(int[] numbers, int target, int[] expectedResult) {
        Solution solution = new Solution();
        int[] actualResult = solution.twoSum(numbers, target);
        assertArrayEquals(expectedResult, actualResult);
    }

}
