package com.geekcircle.Java.SystemDesign.Twitter.Service;

import com.geekcircle.Java.SystemDesign.Twitter.Entity.User;
import com.geekcircle.Java.SystemDesign.Twitter.Exception.UserNotFoundException;

import java.util.LinkedHashMap;
import java.util.Map;

public class UserService {

    Map<Integer,User> users;

    public User getUserByUserId(Integer userId) throws UserNotFoundException{
        if(users.containsKey(userId)){
            return users.get(userId);
        }
        throw new UserNotFoundException("User Not found");
    }

    public UserService() {
        this.users = new LinkedHashMap();
    }

    boolean addUser(String name){
        User user = new User(name);
        users.put(user.getId(), user);
        return true;
    }

    boolean removeUser(Integer userId){
        if(users.containsKey(userId)){
            return users.remove(userId) != null;
        }
        return true;
    }



}
