package Tries.WordSearch_II;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestSolution {
    /*
    Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
    Output: ["eat","oath"]
     */
    @Test
    public void TestCase1() {
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        List<String> expectedResult = Arrays.asList("eat", "oath");

        Solution solution = new Solution();
        List<String> actualResult = solution.findWords(board, words);

        assertEquals(new HashSet<>(expectedResult), new HashSet<>(actualResult));
    }

    /*
    Input: board = [["a","b"],["c","d"]], words = ["abcb"]
    Output: []
     */
    @Test
    public void TestCase2() {
        char[][] board = new char[][]{{'a', 'b'}, {'c', 'd'}};
        String[] words = new String[]{"abcb"};
        List<String> expectedResult = new ArrayList<>();

        Solution solution = new Solution();
        List<String> actualResult = solution.findWords(board, words);

        assertEquals(new HashSet<>(expectedResult), new HashSet<>(actualResult));
    }
}
