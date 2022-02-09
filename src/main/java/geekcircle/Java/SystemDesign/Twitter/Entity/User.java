package com.geekcircle.Java.SystemDesign.Twitter.Entity;

import java.util.List;

public class User {

    Integer id;

    String name;

    Connection connection;

    Timeline timeline;

    public User(String name) {
        id = (int)Math.random() * 1000;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Connection getConnection() {
        return connection;
    }

    public void addToFollower(Integer userId) {
        this.connection.follower.add(userId);
    }

    public void addToFollowing(Integer userId) {
        this.connection.following.add(userId);
    }

    public void removeFromFollower(Integer userId) {
        this.connection.follower.remove(userId);
    }

    public void removeFromFollowing(Integer userId) {
        this.connection.following.remove(userId);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", connection=" + connection +
                '}';
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }
}
