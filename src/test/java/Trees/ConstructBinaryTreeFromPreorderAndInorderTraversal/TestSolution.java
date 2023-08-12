package Trees.ConstructBinaryTreeFromPreorderAndInorderTraversal;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestSolution {
    /*
    Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    Output: [3,9,20,null,null,15,7]
     */
    @Test
    public void TestCase1() {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        Solution solution = new Solution();
        Solution.TreeNode actualResult = solution.buildTree(preorder, inorder);

        assertEquals(3, actualResult.val);
        assertEquals(9, actualResult.left.val);
        assertEquals(20, actualResult.right.val);
        assertNull(actualResult.left.left);
        assertNull(actualResult.left.right);
        assertEquals(15, actualResult.right.left.val);
        assertEquals(7, actualResult.right.right.val);
    }

    /*
    Input: preorder = [-1], inorder = [-1]
    Output: [-1]
     */
    @Test
    public void TestCase2() {
        int[] preorder = new int[]{-1};
        int[] inorder = new int[]{-1};

        Solution solution = new Solution();
        Solution.TreeNode actualResult = solution.buildTree(preorder, inorder);

        assertEquals(-1, actualResult.val);
    }
}
