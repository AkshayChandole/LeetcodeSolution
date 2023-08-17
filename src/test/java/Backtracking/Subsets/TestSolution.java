package Backtracking.Subsets;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: nums = [1,2,3]
    Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     */
    @Test
    public void TestCase1(){
        int[] nums = new int[] {1,2,3};
        List<List<Integer>> expectedResult = new ArrayList<>(Arrays.asList(
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(1)),
                new ArrayList<>(Arrays.asList(2)),
                new ArrayList<>(Arrays.asList(1,2)),
                new ArrayList<>(Arrays.asList(3)),
                new ArrayList<>(Arrays.asList(1,3)),
                new ArrayList<>(Arrays.asList(2,3)),
                new ArrayList<>(Arrays.asList(1,2,3))
        ));

        evaluateSoltion(nums, expectedResult);
    }

    /*
    Input: nums = [0]
    Output: [[],[0]]
     */
    @Test
    public void TestCase2(){
        int[] nums = new int[] {0};
        List<List<Integer>> expectedResult = new ArrayList<>(Arrays.asList(
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(0))
        ));

        evaluateSoltion(nums, expectedResult);
    }

    private void evaluateSoltion(int[] nums, List<List<Integer>> expectedResult) {
        Solution solution = new Solution();
        List<List<Integer>> actualResult = solution.subsets(nums);

        assertEquals(expectedResult, actualResult);
    }
}
