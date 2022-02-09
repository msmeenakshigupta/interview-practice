package com.geekcircle.Java.DesignPatterns.Behavioural.A5_MediatorDP;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-16
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

class ChatRoom {
    static boolean sendMessage(User user, String message) {
        System.out.println("["+ user.getName()+"] : "+message);
        return true;
    }
}

class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean sendMessage(String message) {
        ChatRoom.sendMessage(this, message);
        return true;
    }
}

public class MediatorDesignPattern {
    public static void main(String[] args) {
        User user1 = new User("User 1");
        User user2 = new User("User 2");
        user1.sendMessage("Hello User 2");
        user2.sendMessage("Hi User 1");
    }
}
