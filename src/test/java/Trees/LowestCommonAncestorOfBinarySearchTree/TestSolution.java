package Trees.LowestCommonAncestorOfBinarySearchTree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
    Output: 6
     */
    @Test
    public void TestCase1() {
        Solution.TreeNode root = new Solution.TreeNode(6);
        root.left = new Solution.TreeNode(2);
        root.right = new Solution.TreeNode(8);
        root.left.left = new Solution.TreeNode(0);
        root.left.right = new Solution.TreeNode(4);
        root.right.left = new Solution.TreeNode(7);
        root.right.right = new Solution.TreeNode(9);
        root.left.right.left = new Solution.TreeNode(3);
        root.left.right.right = new Solution.TreeNode(5);

        Solution.TreeNode p = root.left;
        Solution.TreeNode q = root.right;
        Solution.TreeNode expectedResult = root;

        evaluateSolution(root, p, q, expectedResult);
    }

    /*
    Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
    Output: 2
     */
    @Test
    public void TestCase2() {
        Solution.TreeNode root = new Solution.TreeNode(6);
        root.left = new Solution.TreeNode(2);
        root.right = new Solution.TreeNode(8);
        root.left.left = new Solution.TreeNode(0);
        root.left.right = new Solution.TreeNode(4);
        root.right.left = new Solution.TreeNode(7);
        root.right.right = new Solution.TreeNode(9);
        root.left.right.left = new Solution.TreeNode(3);
        root.left.right.right = new Solution.TreeNode(5);

        Solution.TreeNode p = root.left;
        Solution.TreeNode q = root.left.right;
        Solution.TreeNode expectedResult = root.left;

        evaluateSolution(root, p, q, expectedResult);
    }

    /*
    Input: root = [2,1], p = 2, q = 1
    Output: 2
     */
    @Test
    public void TestCase3() {
        Solution.TreeNode root = new Solution.TreeNode(2);
        root.left = new Solution.TreeNode(1);

        Solution.TreeNode p = root;
        Solution.TreeNode q = root.left;
        Solution.TreeNode expectedResult = root;

        evaluateSolution(root, p, q, expectedResult);
    }

    private void evaluateSolution(Solution.TreeNode root, Solution.TreeNode p, Solution.TreeNode q, Solution.TreeNode expectedResult) {
        Solution solution = new Solution();
        Solution.TreeNode actualResult = solution.lowestCommonAncestor(root, p, q);

        assertEquals(expectedResult.val, actualResult.val);
    }
}
