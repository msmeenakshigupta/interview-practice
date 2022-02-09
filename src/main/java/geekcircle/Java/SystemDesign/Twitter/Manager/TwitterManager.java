package com.geekcircle.Java.SystemDesign.Twitter.Manager;

import com.geekcircle.Java.SystemDesign.Twitter.Entity.Tweet;
import com.geekcircle.Java.SystemDesign.Twitter.Entity.User;
import com.geekcircle.Java.SystemDesign.Twitter.Exception.TweetNotFoundException;
import com.geekcircle.Java.SystemDesign.Twitter.Exception.UserNotFoundException;
import com.geekcircle.Java.SystemDesign.Twitter.Service.TweetService;
import com.geekcircle.Java.SystemDesign.Twitter.Service.UserService;

import java.util.List;

public class TwitterManager {

    UserService userService = new UserService();
    TweetService tweetService = new TweetService();

    Tweet doTweet(Integer userId, String content) throws UserNotFoundException {
        User user = userService.getUserByUserId(userId);
        Tweet tweet = tweetService.postTweet(user, content);
        return tweet;
    }

    boolean deleteTweet(Integer userId, Integer tweetId) throws UserNotFoundException, TweetNotFoundException {
        User user = userService.getUserByUserId(userId);
        tweetService.getTweetByTweetId(user, tweetId);
        return true;
    }

    boolean followUser(Integer fromUserId, Integer toUserId) throws UserNotFoundException{
        User fromUser = userService.getUserByUserId(fromUserId);
        User toUser = userService.getUserByUserId(toUserId);
        fromUser.addToFollowing(toUserId);
        toUser.addToFollower(fromUserId);
        return true;
    }
}
