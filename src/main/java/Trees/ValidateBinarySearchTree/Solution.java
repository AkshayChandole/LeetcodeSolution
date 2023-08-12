package Trees.ValidateBinarySearchTree;

// **********************************************************************************
// Optimal Solution -

/**
 * Time Complexity - O(n) where N is the number of nodes, as each node is visited once.
 * Space Complexity - O(h) where h is the height of the tree, representing the recursion stack space.
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBinarySearchTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBinarySearchTree(TreeNode node, long minValue, long maxValue) {
        if (node == null) return true;

        if ((node.val <= minValue) || (node.val >= maxValue)) return false;

        return isValidBinarySearchTree(node.left, minValue, node.val) && isValidBinarySearchTree(node.right, node.val, maxValue);
    }


    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
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

// **********************************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(n^2) in the worst case, since for each node, we traverse all its descendants.
 * Space Complexity - O(h) where h is the height of the tree, representing the recursion stack space.
 */
class Solution1 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        // Check left subtree for values less than root
        if (!isAllValuesLessThanRoot(root.left, root.val)) return false;

        // Check right subtree for values less than root
        if (!isAllValuesGreaterThanRoot(root.right, root.val)) return false;

        // Check left and right subtree
        return isValidBST(root.left) && isValidBST(root.right);
    }

    private boolean isAllValuesGreaterThanRoot(TreeNode node, int value) {
        if (node == null) return true;

        if (node.val <= value) return false;

        return isAllValuesGreaterThanRoot(node.left, value) && isAllValuesGreaterThanRoot(node.right, value);
    }

    private boolean isAllValuesLessThanRoot(TreeNode node, int value) {
        if (node == null) return true;

        if (node.val >= value) return false;

        return isAllValuesLessThanRoot(node.left, value) && isAllValuesLessThanRoot(node.right, value);
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
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
