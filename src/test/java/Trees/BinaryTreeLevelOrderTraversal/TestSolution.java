package Trees.BinaryTreeLevelOrderTraversal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: root = [3,9,20,null,null,15,7]
    Output: [[3],[9,20],[15,7]]
     */
    @Test
    public void TestCase1() {
        Solution.TreeNode root = new Solution.TreeNode(3);
        root.left = new Solution.TreeNode(9);
        root.right = new Solution.TreeNode(20);
        root.right.left = new Solution.TreeNode(15);
        root.right.right = new Solution.TreeNode(7);

        List<List<Integer>> expectedResult = Arrays.asList(Arrays.asList(3), Arrays.asList(9, 20), Arrays.asList(15, 7));

        evaluateSolution(root, expectedResult);
    }

    /*
    Input: root = [1]
    Output: [[1]]
     */
    @Test
    public void TestCase2() {
        Solution.TreeNode root = new Solution.TreeNode(1);

        List<List<Integer>> expectedResult = Arrays.asList(Arrays.asList(1));

        evaluateSolution(root, expectedResult);
    }

    /*
    Input: root = []
    Output: []
     */
    @Test
    public void TestCase3() {
        Solution.TreeNode root = null;

        List<List<Integer>> expectedResult = new ArrayList<>();

        evaluateSolution(root, expectedResult);
    }

    private void evaluateSolution(Solution.TreeNode root, List<List<Integer>> expectedResult) {
        Solution solution = new Solution();
        List<List<Integer>> actualResult = solution.levelOrder(root);

        assertEquals(expectedResult, actualResult);
    }
}
