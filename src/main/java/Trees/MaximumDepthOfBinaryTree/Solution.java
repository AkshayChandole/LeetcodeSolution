package Trees.MaximumDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

// *********************************************************************
// Optimal Solution using recursion -

/**
 * Time Complexity - O(n)
 * Space Complexity - O(1) + O(h) recursion stack space where h is height of binary tree.
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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

// ***********************************************************************
// Brute force solution using queue -

/**
 * Time Complexity - O(n^2)
 * Space Complexity - O(n)
 */
class Solution1 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                root = queue.remove();

                if (root.left != null) {
                    queue.add(root.left);
                }

                if (root.right != null) {
                    queue.add(root.right);
                }

                size--;
            }
            depth++;
        }

        return depth;
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