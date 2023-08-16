package HeapOrPriorityQueue.DesignTwitter;

import java.util.*;

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */


// *********************************************************************************
// Optimal Solution -

/*
 * Time Complexity -
 *       postTweet - O(1)
 *       getNewsFeed - O(U log T), where U is the number of users the current user follows and T is the average number of tweets per user.
 *       follow - O(1)
 *       unfollow - O(1)
 * Space Complexity -
 *       O(U + T + F) where U is the number of users, T is the number of tweets, and F is the number of follow relations.
 */
class Twitter {
    Map<Integer, List<Tweet>> userTweets;
    Map<Integer, Set<Integer>> followers;
    int timestamp;

    public Twitter() {
        userTweets = new HashMap<>();
        followers = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        userTweets.putIfAbsent(userId, new LinkedList<>());
        userTweets.get(userId).add(0, new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> heap = new PriorityQueue<>((t1, t2) -> t2.time - t1.time);

        // Add user's tweets
        if (userTweets.containsKey(userId)) {
            heap.addAll(userTweets.get(userId));
        }

        // Add followees' tweets
        for (int followeeId : followers.getOrDefault(userId, new HashSet<>())) {
            if (userTweets.containsKey(followeeId)) {
                heap.addAll(userTweets.get(followeeId));
            }
        }

        List<Integer> feed = new ArrayList<>();
        while (!heap.isEmpty() && feed.size() < 10) {
            feed.add(heap.poll().tweetId);
        }
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            followers.putIfAbsent(followerId, new HashSet<>());
            followers.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }

    class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }
}


// *********************************************************************************
// Brute Force Solution -

/*
 * Time Complexity -
 *       postTweet - O(1)
 *       getNewsFeed - O(n), where n is the number of all tweets.
 *       follow - O(1)
 *       unfollow - O(1)
 * Space Complexity -
 *       O(U + T + F) where U is the number of users, T is the number of tweets, and F is the number of follow relations.
 */
class Twitter1 {
    List<Tweet> tweets;
    Map<Integer, Set<Integer>> followers;

    public Twitter1() {
        tweets = new ArrayList<>();
        followers = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.add(new Tweet(userId, tweetId, tweets.size()));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        for (int i = tweets.size() - 1; i >= 0 & feed.size() < 10; i--) {
            Tweet t = tweets.get(i);
            if (t.userId == userId || followers.getOrDefault(userId, new HashSet<>()).contains(t.userId)) {
                feed.add(t.tweetId);
            }
        }
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }

    class Tweet {
        int userId;
        int tweetId;
        int timeStamp;

        Tweet(int userId, int tweetId, int timeStamp) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.timeStamp = timeStamp;
        }
    }
}


