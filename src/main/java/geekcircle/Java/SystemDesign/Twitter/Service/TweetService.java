package com.geekcircle.Java.SystemDesign.Twitter.Service;

import com.geekcircle.Java.SystemDesign.Twitter.Entity.Tweet;
import com.geekcircle.Java.SystemDesign.Twitter.Entity.User;
import com.geekcircle.Java.SystemDesign.Twitter.Exception.TweetNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class TweetService {

    Map<Integer, Map<Integer, Tweet>> tweets = new LinkedHashMap<>();

    public Tweet postTweet(User user, String content){
        Tweet tweet = new Tweet(user, content, new LinkedList<>(), getAllHashTags(content));
        Map<Integer, Tweet> tweetMap;
        if(tweets.containsKey(user.getId())){
            tweetMap = tweets.get(user.getId());
        } else {
            tweetMap = new LinkedHashMap<>();
        }
        tweetMap.put(tweet.getId(), tweet);
        return tweet;
    }

    public Tweet getTweetByTweetId(User user, Integer tweetId) throws TweetNotFoundException{
        if(tweets.containsKey(user.getId())){
            Map<Integer, Tweet> tweetMap = tweets.get(user.getId());
            if(tweetMap.containsKey(tweetId)){
                return tweetMap.get(tweetId);
            } else {
                throw new TweetNotFoundException("Tweet not found");
            }
        } else {
            throw new TweetNotFoundException("User Not posted any tweet");
        }
    }

    public List<String> getAllHashTags(String content){
        String[] literals = content.split(" ");
        return Arrays.stream(literals).filter(i -> i.startsWith("#")).collect(Collectors.toList());
    }

}
