package Tries.WordSearch_II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// **************************************************************************************

/**
 * Time Complexity -
 *          O(N * M * L + K * L), where:
 *                                      N x M is the size of the board.
 *                                      L is the maximum length of words.
 *                                      K is the number of words.
 * Space Complexity -
 *          O(K * L) for the Trie
 */

class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public String word = null; // To store full words at the end nodes
}

public class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        // Construct the Trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = word;
        }

        // DFS on the board
        Set<String> resultSet = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, resultSet);
            }
        }
        return new ArrayList<>(resultSet);
    }

    private void dfs(char[][] board, int x, int y, TrieNode parent, Set<String> resultSet) {
        char letter = board[x][y];
        if (letter == '#' || parent.children[letter - 'a'] == null) return;

        TrieNode currNode = parent.children[letter - 'a'];
        if (currNode.word != null) {
            resultSet.add(currNode.word);
            currNode.word = null; // Optional: remove word from Trie to prevent duplicate addition
        }

        board[x][y] = '#'; // mark as visited

        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                dfs(board, newX, newY, currNode, resultSet);
            }
        }

        board[x][y] = letter; // backtrack
    }
}