package Tries.DesignAddAndSearchWordsDataStructure;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    /*
    Input:
        ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
        [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
    Output:
        [null,null,null,null,false,true,true,true]
     */
    @Test
    public void TestCase(){
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        assertEquals(false,wordDictionary.search("pad"));
        assertEquals(true,wordDictionary.search("bad"));
        assertEquals(true,wordDictionary.search(".ad"));
        assertEquals(true,wordDictionary.search("b.."));
    }
}
