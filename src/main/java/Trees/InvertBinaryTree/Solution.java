package Trees.InvertBinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

// ******************************************************************************
// Optimal Solution using recursion -

/**
 * Time Complexity - O(n)   where n is the number of nodes in binary tree.
 * Space Complexity - O(h) where h is the height of tree.
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        /* recursive calls */
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        /* swap the left and right pointers */
        root.left = right;
        root.right = left;

        return root;
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

// ******************************************************************************
// Solution using queue (similar to level order traversal) -

/**
 * Time Complexity - O(n)   where n is the number of nodes in binary tree.
 * Space Complexity - O(n)
 */
class Solution2 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        // maintain a queue and push the root node
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        // loop till queue is empty
        while (!queue.isEmpty()) {
            // dequeue front node
            TreeNode currentNode = queue.poll();

            // swap the left child with the right child
            swap(currentNode);

            // enqueue left child of the popped node
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            // enqueue right child of the popped node
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }

        }

        return root;
    }

    // Utility function to swap left subtree with right subtree
    private void swap(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
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

// ******************************************************************************
// Solution using Stack (similar to iterative pre-order traversal) -

/**
 * Time Complexity - O(n)   where n is the number of nodes in binary tree.
 * Space Complexity - O(n)
 */
class Solution1 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        // maintain a stack and push the root node
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);

        // loop till stack is empty
        while (!stack.isEmpty()) {
            // pop the top node from the stack
            TreeNode currentNode = stack.pop();

            // swap the left child with the right child
            swap(currentNode);

            // push the right child of the popped node into the stack
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }

            // push the left child of the popped node into the stack
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }

        }

        return root;
    }

    // Utility function to swap left subtree with right subtree
    private void swap(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
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

