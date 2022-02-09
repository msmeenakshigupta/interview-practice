package com.geekcircle.Java.SystemDesign.Twitter.Entity;

import java.util.LinkedHashSet;
import java.util.Set;

public class Trend {

    final String hashTag;

    Integer count;

    Set<Integer> tweetIds = new LinkedHashSet<>();

    public Trend(String hashTag, Integer tweetId) {
        this.hashTag = hashTag;
        this.count = 1;
        tweetIds.add(tweetId);
    }

    public String getHashTag() {
        return hashTag;
    }

    public Integer getCount() {
        return count;
    }

    public void addCount() {
        this.count++;
    }

    public Set<Integer> getTweetIds() {
        return tweetIds;
    }

    public void addTweetIds(Set<Integer> tweetIds) {
        this.tweetIds = tweetIds;
    }
}
