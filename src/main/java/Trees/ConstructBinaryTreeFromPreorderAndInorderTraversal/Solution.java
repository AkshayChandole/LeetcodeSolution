package Trees.ConstructBinaryTreeFromPreorderAndInorderTraversal;

import java.util.HashMap;
import java.util.Map;

// **************************************************************************
// Optimal Solution -

/**
 * Time Complexity - O(n), where n is the number of nodes, as we only traverse each node once.
 * Space Complexity - O(n) for the HashMap + O(h) for the recursion stack.
 */
class Solution {
    int preOrderStart = 0;
    Map<Integer, Integer> inOrderPositionsMap = new HashMap<>();

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            inOrderPositionsMap.put(inOrder[i], i);
        }
        return build(preOrder, 0, inOrder.length - 1);
    }

    private TreeNode build(int[] preOrder, int inOrderStart, int inOrderEnd) {
        if (inOrderStart > inOrderEnd) return null;

        TreeNode root = new TreeNode(preOrder[preOrderStart++]);

        if (inOrderStart == inOrderEnd) return root;

        int index = inOrderPositionsMap.get(root.val);

        root.left = build(preOrder, inOrderStart, index - 1);
        root.right = build(preOrder, index + 1, inOrderEnd);

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


// **************************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(n^2). For every node, we might search for it in the inorder array.
 * Space Complexity - O(h), where h is the height of the tree, representing the recursion stack space
 */
class Solution1 {
    int preOrderStart = 0;

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        return build(preOrder, inOrder, 0, inOrder.length - 1);
    }

    private TreeNode build(int[] preOrder, int[] inOrder, int inOrderStart, int inOrderEnd) {
        if (inOrderStart > inOrderEnd) return null;

        TreeNode root = new TreeNode(preOrder[preOrderStart++]);

        if (inOrderStart == inOrderEnd) return root;

        int index = findInOrderRootIndex(inOrder, inOrderStart, inOrderEnd, root.val);

        root.left = build(preOrder, inOrder, inOrderStart, index - 1);
        root.right = build(preOrder, inOrder, index + 1, inOrderEnd);

        return root;
    }

    private int findInOrderRootIndex(int[] inorder, int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == value) {
                return i;
            }
        }
        return -1;
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
