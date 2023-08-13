package Tries.DesignAddAndSearchWordsDataStructure;

import java.util.HashMap;

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

// ********************************************************************************

/**
 * Time Complexity -
 * Add Word: O(m), where m is the length of the word to be added
 * Search: In the worst-case scenario (when there are many wildcards), it's O(26^m) because for each wildcard character, you might need to explore 26 possibilities.
 * Space Complexity -
 * O(n * m), where n is the number of words and m is the average length of the words.
 */
public class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
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

    // Returns true if the word is in the data structure.
    public boolean search(String word) {
        if (word == null) return false;
        return searchInNode(word, root);
    }

    private boolean searchInNode(String word, TrieNode current) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (char x : current.children.keySet()) {
                    if (searchInNode(word.substring(i + 1), current.getChild(x))) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!current.hasChild(ch)) return false;
                current = current.getChild(ch);
            }
        }

        return current.isEndOfWord;
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