package Trees.BalancedBinaryTree;


// ***********************************************************************************
// Optimal Solution using post order traversal -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(1) Extra Space + O(h) Recursion Stack space (Where “h”  is the height of binary tree)
 */
public class Solution {
    private boolean isTreeBalanced = false;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        isTreeBalanced = true;
        dfs(root);
        return isTreeBalanced;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int leftTreeHeight = dfs(root.left);
        int rightTreeHeight = dfs(root.right);

        if (Math.abs(leftTreeHeight - rightTreeHeight) > 1) {
            isTreeBalanced = false;
        }

        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

// ***********************************************************************************
// Brute Force Solution using recursion -

/**
 * Time Complexity - O(n^2)
 * Space Complexity -  O(1) (Extra Space) + O(h) ( Recursive Stack Space where “h” is the height of tree )
 */
class Solution1 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftTreeHeight = height(root.left);
        int rightTreeHeight = height(root.right);
        if (Math.abs(leftTreeHeight - rightTreeHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        } else {
            return false;
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
