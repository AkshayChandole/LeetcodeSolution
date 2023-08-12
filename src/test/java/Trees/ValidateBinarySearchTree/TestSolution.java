package Trees.ValidateBinarySearchTree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: root = [2,1,3]
    Output: true
     */
    @Test
    public void TestCase1() {
        Solution.TreeNode root = new Solution.TreeNode(2);
        root.left = new Solution.TreeNode(1);
        root.right = new Solution.TreeNode(3);

        boolean expectedResult = true;

        evaluateSolution(root, expectedResult);
    }

    /*
    Input: root = [5,1,4,null,null,3,6]
    Output: false
     */
    @Test
    public void TestCase2() {
        Solution.TreeNode root = new Solution.TreeNode(5);
        root.left = new Solution.TreeNode(1);
        root.right = new Solution.TreeNode(4);
        root.right.left = new Solution.TreeNode(3);
        root.right.right = new Solution.TreeNode(6);
        boolean expectedResult = false;

        evaluateSolution(root, expectedResult);
    }

    private void evaluateSolution(Solution.TreeNode root, boolean expectedResult) {
        Solution solution = new Solution();
        boolean actualResult = solution.isValidBST(root);

        assertEquals(expectedResult, actualResult);
    }
}
