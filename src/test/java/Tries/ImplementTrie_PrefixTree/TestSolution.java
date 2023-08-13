package Tries.ImplementTrie_PrefixTree;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    /*
    Input:
        ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
        [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
    Output:
        [null, null, true, false, true, null, true]
     */
    @Test
    public void TestCase() {
        Trie trie = new Trie();
        trie.insert("apple");
        assertEquals(true, trie.search("apple"));
        assertEquals(false, trie.search("app"));
        assertEquals(true, trie.startsWith("app"));
        trie.insert("app");
        assertEquals(true, trie.search("app"));
    }
}
