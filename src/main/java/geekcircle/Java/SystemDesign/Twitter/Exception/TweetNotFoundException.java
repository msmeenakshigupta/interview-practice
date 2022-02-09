package com.geekcircle.Java.SystemDesign.Twitter.Exception;

public class TweetNotFoundException extends Exception {

    private String message;

    public TweetNotFoundException(String s){
        super(s);
        this.message = s;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
