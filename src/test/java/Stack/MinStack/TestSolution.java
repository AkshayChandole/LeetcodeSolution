package Stack.MinStack;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSolution {

    @Test
    public void TestCase1() {
        Solution.MinStack minStack = new Solution.MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int actualMinimum1 = minStack.getMin();
        minStack.pop();
        int actualTop = minStack.top();
        int actualMinimum2 = minStack.getMin();

        int expectedMinimum1 = -3;
        int expectedTop = 0;
        int expectedMinimum2 = -2;

        assertEquals(expectedMinimum1, actualMinimum1);
        assertEquals(expectedTop, actualTop);
        assertEquals(expectedMinimum2, actualMinimum2);
    }
}
