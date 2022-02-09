package com.geekcircle.Java.SystemDesign.Splitwise.Entity;

public abstract class Split {

    private User user;

    public Split(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
