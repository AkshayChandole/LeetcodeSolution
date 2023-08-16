package HeapOrPriorityQueue.DesignTwitter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    /*
    Input:
        ["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
        [[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
    Output:
        [null, null, [5], null, null, [6, 5], null, [5]]
     */
    @Test
    public void TestCase1(){
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        assertEquals(new ArrayList<>(Arrays.asList(5)),twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        assertEquals(new ArrayList<>(Arrays.asList(6, 5)),twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        assertEquals(new ArrayList<>(Arrays.asList(5)),twitter.getNewsFeed(1));
    }
}
