package Tries.ImplementTrie_PrefixTree;

import java.util.HashMap;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


// ***********************************************************

/**
 * Time Complexity -
 * Insertion: O(m), where m is the length of the word.
 * Search: O(m), where m is the length of the word.
 * StartsWith: O(m), where m is the length of the prefix.
 * Space Complexity - O(n * m), where n is the total number of words and m is the average length of the words.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        if (word == null) return;

        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch)) {
                current.addChild(ch);
            }
            current = current.getChild(ch);
        }

        current.isEndOfWord = true;
    }

    // Search for a specific word in the Trie
    public boolean search(String word) {
        if (word == null) return false;

        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch)) {
                return false;
            }
            current = current.getChild(ch);
        }

        return current.isEndOfWord;
    }

    // Check if any word in the Trie starts with a specific prefix
    public boolean startsWith(String prefix) {
        if (prefix == null) return false;

        TrieNode current = root;

        for (char ch : prefix.toCharArray()) {
            if (!current.hasChild(ch)) {
                return false;
            }
            current = current.getChild(ch);
        }

        return true;
    }
}

class TrieNode {
    char value;
    boolean isEndOfWord;
    HashMap<Character, TrieNode> children = new HashMap<>();

    public TrieNode(char ch) {
        this.value = ch;
    }

    public TrieNode() {

    }

    public boolean hasChild(char ch) {
        return children.containsKey(ch);
    }

    public void addChild(char ch) {
        children.put(ch, new TrieNode(ch));
    }

    public TrieNode getChild(char ch) {
        return children.get(ch);
    }
}

