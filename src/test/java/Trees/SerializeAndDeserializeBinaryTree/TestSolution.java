package Trees.SerializeAndDeserializeBinaryTree;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestSolution {
    /*
    Input: root = [1,2,3,null,null,4,5]
    Output: [1,2,3,null,null,4,5]
     */
    @Test
    public void TestCase1() {
        Codec.TreeNode root = new Codec.TreeNode(1);
        root.left = new Codec.TreeNode(2);
        root.right = new Codec.TreeNode(3);
        root.right.left = new Codec.TreeNode(4);
        root.right.right = new Codec.TreeNode(5);

        Codec codec = new Codec();
        Codec.TreeNode actualResult = codec.deserialize(codec.serialize(root));

        assertEquals(1, actualResult.val);
        assertEquals(2, actualResult.left.val);
        assertEquals(3, actualResult.right.val);
        assertNull(actualResult.left.left);
        assertNull(actualResult.left.right);
        assertEquals(4, actualResult.right.left.val);
        assertEquals(5, actualResult.right.right.val);
    }

    /*
    Input: root = []
    Output: []
     */
    @Test
    public void TestCase2() {
        Codec.TreeNode root = null;

        Codec codec = new Codec();
        Codec.TreeNode actualResult = codec.deserialize(codec.serialize(root));

        assertNull(actualResult);
    }
}
