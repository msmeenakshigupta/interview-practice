package com.geekcircle.Java.SystemDesign.Splitwise.Service;

import com.geekcircle.Java.SystemDesign.Splitwise.Entity.User;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    Map<Integer, User> userMap;

    public UserService() {
        this.userMap = new LinkedHashMap<>();
    }

    public User addUser(int id, String name){
        User user = new User(id, name);
        userMap.put(id, user);
        return user;
    }

    public User getUser(int id){
        return userMap.get(id);
    }
}
