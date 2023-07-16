package ArraysAndHashing.EncodeAndDecodeStrings;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void testCase() {
        String originalString = "Hello World! Welcome to my github repository.";
        String[] originalStringList = originalString.split(" ");
        String encodedString = solution.encode(Arrays.asList(originalStringList));
        List<String> decodedStringList = solution.decode(encodedString);
        String resultString = String.join(" ", decodedStringList);
        assertEquals(originalString, resultString);
    }
}
