package ArraysAndHashing.ProductOfArrayExceptSelf;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void testCase1(){
        int[] numbers = new int[]{1,2,3,4};
        int[] expectedResult =  new int[]{24, 12, 8, 6};
        evaluateResult(numbers, expectedResult);
    }

    @Test
    public void testCase2(){
        int[] numbers = new int[]{-1,1,0,-3,3};
        int[] expectedResult =  new int[]{0,0,9,0,0};
        evaluateResult(numbers, expectedResult);
    }
    private void evaluateResult(int[] numbers, int[] expectedResult){
        int[] result = solution.productExceptSelf(numbers);
        assertArrayEquals(expectedResult, result);
    }

}
