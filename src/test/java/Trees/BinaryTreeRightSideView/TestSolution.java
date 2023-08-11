package Trees.BinaryTreeRightSideView;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: root = [1,2,3,null,5,null,4]
    Output: [1,3,4]
     */
    @Test
    public void TestCase1() {
        Solution.TreeNode root = new Solution.TreeNode(1);
        root.left = new Solution.TreeNode(2);
        root.right = new Solution.TreeNode(3);
        root.left.right = new Solution.TreeNode(5);
        root.right.right = new Solution.TreeNode(4);

        List<Integer> expectedResult = Arrays.asList(1, 3, 4);

        evaluateSolution(root, expectedResult);
    }

    /*
    Input: root = [1,null,3]
    Output: [1,3]
     */
    @Test
    public void TestCase2() {
        Solution.TreeNode root = new Solution.TreeNode(1);
        root.right = new Solution.TreeNode(3);

        List<Integer> expectedResult = Arrays.asList(1, 3);

        evaluateSolution(root, expectedResult);
    }

    /*
    Input: root = []
    Output: []
     */
    @Test
    public void TestCase3() {
        Solution.TreeNode root = null;

        List<Integer> expectedResult = new ArrayList<>();

        evaluateSolution(root, expectedResult);
    }

    private void evaluateSolution(Solution.TreeNode root, List<Integer> expectedResult) {
        Solution solution = new Solution();
        List<Integer> actualResult = solution.rightSideView(root);

        assertEquals(expectedResult, actualResult);
    }
}
