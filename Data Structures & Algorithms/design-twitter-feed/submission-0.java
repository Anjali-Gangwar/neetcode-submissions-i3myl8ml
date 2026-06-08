class Twitter {

    private static int timestamp = 0;

    class Tweet {
        int tweetId;
        int time;
        Tweet next;

        Tweet(int tweetId) {
            this.tweetId = tweetId;
            this.time = timestamp++;
        }
    }

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, Tweet> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        Tweet newTweet = new Tweet(tweetId);

        if (tweetMap.containsKey(userId)) {
            newTweet.next = tweetMap.get(userId);
        }

        tweetMap.put(userId, newTweet);
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> feed = new ArrayList<>();

        PriorityQueue<Tweet> pq =
                new PriorityQueue<>((a, b) -> b.time - a.time);

        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        for (int followee : followMap.get(userId)) {

            Tweet tweetHead = tweetMap.get(followee);

            if (tweetHead != null) {
                pq.offer(tweetHead);
            }
        }

        while (!pq.isEmpty() && feed.size() < 10) {

            Tweet curr = pq.poll();

            feed.add(curr.tweetId);

            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {

        followMap.putIfAbsent(followerId, new HashSet<>());

        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (followMap.containsKey(followerId)
                && followerId != followeeId) {

            followMap.get(followerId).remove(followeeId);
        }
    }
}