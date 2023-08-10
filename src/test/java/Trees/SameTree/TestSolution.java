package Trees.SameTree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: p = [1,2,3], q = [1,2,3]
    Output: true
     */
    @Test
    public void TestCase1() {
        Solution.TreeNode p = new Solution.TreeNode(1);
        p.left = new Solution.TreeNode(2);
        p.right = new Solution.TreeNode(3);

        Solution.TreeNode q = new Solution.TreeNode(1);
        q.left = new Solution.TreeNode(2);
        q.right = new Solution.TreeNode(3);

        boolean expectedResult = true;

        evaluateResult(p, q, expectedResult);
    }

    /*
    Input: p = [1,2], q = [1,null,2]
    Output: false
     */
    @Test
    public void TestCase2() {
        Solution.TreeNode p = new Solution.TreeNode(1);
        p.left = new Solution.TreeNode(2);

        Solution.TreeNode q = new Solution.TreeNode(1);
        q.right = new Solution.TreeNode(2);

        boolean expectedResult = false;

        evaluateResult(p, q, expectedResult);
    }

    /*
    Input: p = [1,2,1], q = [1,1,2]
    Output: false
     */
    @Test
    public void TestCase3() {
        Solution.TreeNode p = new Solution.TreeNode(1);
        p.left = new Solution.TreeNode(2);
        p.right = new Solution.TreeNode(1);

        Solution.TreeNode q = new Solution.TreeNode(1);
        q.left = new Solution.TreeNode(1);
        q.right = new Solution.TreeNode(2);

        boolean expectedResult = false;

        evaluateResult(p, q, expectedResult);
    }

    private void evaluateResult(Solution.TreeNode p, Solution.TreeNode q, boolean expectedResult) {
        Solution solution = new Solution();
        boolean actualResult = solution.isSameTree(p, q);

        assertEquals(expectedResult, actualResult);
    }

}
