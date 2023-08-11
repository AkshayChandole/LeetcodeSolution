package Trees.LowestCommonAncestorOfBinarySearchTree;

// ********************************************************************************
// Optimal Solution -

/**
 * Time Complexity - O(n) where n is the number of nodes
 * Space Complexity - O(h)
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

// ********************************************************************************
// Solution using recursion -

/**
 * Time Complexity - O(n) where n is the number of nodes
 * Space Complexity - O(n)
 */
class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // result
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            // both left and right are not null, we found the result.
            return root;
        }
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
