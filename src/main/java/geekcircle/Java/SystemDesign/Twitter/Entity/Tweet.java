package com.geekcircle.Java.SystemDesign.Twitter.Entity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Tweet {

    Integer id;

    User user;

    String content;

    List<String> images;

    List<String> hashTags;

    Date datetime;

    public Tweet(User user, String content, List<String> images, List<String> hashTags) {
        this.id = (int)Math.random() * 1000;;
        this.content = content.trim();
        this.images = images;
        this.user = user;
        this.hashTags = hashTags;
        this.datetime = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
