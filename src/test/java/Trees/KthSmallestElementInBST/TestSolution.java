package Trees.KthSmallestElementInBST;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: root = [3,1,4,null,2], k = 1
    Output: 1
     */
    @Test
    public void TestCase1() {
        Solution.TreeNode root = new Solution.TreeNode(3);
        root.left = new Solution.TreeNode(1);
        root.right = new Solution.TreeNode(4);
        root.left.right = new Solution.TreeNode(2);

        int k = 1;

        int expectedResult = 1;

        evaluateSolution(root, k, expectedResult);

    }

    /*
    Input: root = [5,3,6,2,4,null,null,1], k = 3
    Output: 3
     */
    @Test
    public void TestCase2() {
        Solution.TreeNode root = new Solution.TreeNode(5);
        root.left = new Solution.TreeNode(3);
        root.right = new Solution.TreeNode(6);
        root.left.left = new Solution.TreeNode(2);
        root.left.right = new Solution.TreeNode(4);
        root.left.left.left = new Solution.TreeNode(1);

        int k = 3;

        int expectedResult = 3;

        evaluateSolution(root, k, expectedResult);

    }

    private void evaluateSolution(Solution.TreeNode root, int k, int expectedResult) {
        Solution solution = new Solution();
        int actualResult = solution.kthSmallest(root, k);

        assertEquals(expectedResult, actualResult);
    }
}
