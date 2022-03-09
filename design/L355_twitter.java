import java.util.*;

public class L355_twitter {

    public static  void main(String[] args) {

    }
}

class tweet implements  Comparable<tweet> {

    private int tweetId;
    private int ts;
    private int userId;

    tweet(int tid, int userid, int ts) {
        this.tweetId = tid;
        this.userId = userid;
        this.ts = ts;
    }

    @Override
    public int compareTo(tweet t2) {
        return t2.ts - this.ts;
    }
}




class twitter {
    List<Integer> users;
    Map<Integer, HashSet<Integer>> followerMap;
    Map<Integer, LinkedList<tweet>> userposts;
    int timestamp;


    twitter() {
        List<Integer> users = new ArrayList<>();
        Map<Integer, List<Integer>> followerMap = new HashMap<>();
        Map<Integer, LinkedList<Integer>> userposts = new HashMap<>();
        timestamp = 0;

    }

    public void postTweet(int userId, int tweetId) {

        LinkedList<tweet> tweets = userposts.getOrDefault(userId, new LinkedList<>());
        tweet t = new tweet(userId, tweetId, timestamp++);
        tweets.add(t);

        //for the first time user is posting the tweet.so initialize the follower map

        if (!followerMap.containsKey(userId)) {
            HashSet<Integer> followlist = followerMap.getOrDefault(userId, new HashSet<>());
            followerMap.put(userId, followlist);
        }
    }

    public List<Integer> getNewsFeed(int userId) {


        return null;
    }

    public void follow(int followerId, int foloweeId) {

       // HashSet<tweet> followlist = followerMap.getOrDefault(followerId, new HashSet<>());
        //followlist.add(followerId);
    }


    public void unFollow(int followerId, int followeeId) {

        if (followerId == followeeId) {
            return;
        }

        if (followerMap.containsKey(followerId)) {
            HashSet<Integer> followlist = followerMap.get(followerId);
            followlist.remove(followerId);
        }

    }
}
